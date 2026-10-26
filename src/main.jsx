
import { useEffect, useState } from "react";
import { createRoot } from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import "./style.css";

import ThemeParkForm from "./components/ThemeParkForm";
import ThemeParkList from "./components/ThemeParkList";
import ThemeParkService from "./service/ThemeParkService";

function App() {
    const [parks, setParks] = useState([]);
    const [editingPark, setEditingPark] = useState(null);
    const [loading, setLoading] = useState(true);
    const [saving, setSaving] = useState(false);
    const [notice, setNotice] = useState({
        type: "",
        text: ""
    });

    async function loadParks() {
        setLoading(true);

        try {
            const data = await ThemeParkService.getAll();
            setParks(data);
        } catch (error) {
            setNotice({
                type: "danger",
                text: `Could not load theme parks: ${error.message}`
            });
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        loadParks();
    }, []);

    async function handleSubmit(park) {
        setSaving(true);
        setNotice({ type: "", text: "" });

        try {
            if (editingPark) {
                await ThemeParkService.update(editingPark.id, park);
                setNotice({
                    type: "success",
                    text: "Theme park updated successfully."
                });
            } else {
                await ThemeParkService.add(park);
                setNotice({
                    type: "success",
                    text: "Theme park added successfully."
                });
            }

            setEditingPark(null);
            await loadParks();
        } catch (error) {
            setNotice({
                type: "danger",
                text: `Operation failed: ${error.message}`
            });
        } finally {
            setSaving(false);
        }
    }

    async function handleDelete(id) {
        if (!window.confirm("Are you sure you want to delete this theme park?")) {
            return;
        }

        try {
            await ThemeParkService.delete(id);
            setNotice({
                type: "success",
                text: "Theme park deleted successfully."
            });

            if (editingPark?.id === id) {
                setEditingPark(null);
            }

            await loadParks();
        } catch (error) {
            setNotice({
                type: "danger",
                text: `Delete failed: ${error.message}`
            });
        }
    }

    return (
        <div className="container py-4">
            <div className="text-center mb-4">
                <h1>Theme Park Management System</h1>
                <p className="text-muted">
                    Manage theme parks, rides, locations and ticket prices.
                </p>
            </div>

            {notice.text && (
                <div className={`alert alert-${notice.type}`} role="alert">
                    {notice.text}
                </div>
            )}

            <ThemeParkForm
                onSubmit={handleSubmit}
                editingPark={editingPark}
                onCancel={() => setEditingPark(null)}
                saving={saving}
            />

            <ThemeParkList
                parks={parks}
                loading={loading}
                onEdit={setEditingPark}
                onDelete={handleDelete}
            />
        </div>
    );
}

createRoot(document.getElementById("root")).render(<App />);
