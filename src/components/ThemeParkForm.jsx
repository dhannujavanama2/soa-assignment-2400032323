
import { useEffect, useState } from "react";

function ThemeParkForm({ onSubmit, editingPark, onCancel, saving }) {
    const [form, setForm] = useState({
        parkName: "",
        location: "",
        rideCount: "",
        ticketPrice: ""
    });

    useEffect(() => {
        if (editingPark) {
            setForm({
                parkName: editingPark.parkName || "",
                location: editingPark.location || "",
                rideCount: editingPark.rideCount ?? "",
                ticketPrice: editingPark.ticketPrice ?? ""
            });
        } else {
            setForm({
                parkName: "",
                location: "",
                rideCount: "",
                ticketPrice: ""
            });
        }
    }, [editingPark]);

    function handleChange(event) {
        const { name, value } = event.target;
        setForm((previous) => ({ ...previous, [name]: value }));
    }

    async function handleSubmit(event) {
        event.preventDefault();

        await onSubmit({
            parkName: form.parkName.trim(),
            location: form.location.trim(),
            rideCount: Number(form.rideCount),
            ticketPrice: Number(form.ticketPrice)
        });
    }

    return (
        <div className="card shadow-sm mb-4">
            <div className="card-header fw-bold">
                {editingPark ? "Update Theme Park" : "Add Theme Park"}
            </div>

            <div className="card-body">
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label className="form-label">Park Name</label>
                        <input
                            className="form-control"
                            name="parkName"
                            value={form.parkName}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Location</label>
                        <input
                            className="form-control"
                            name="location"
                            value={form.location}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Number of Rides</label>
                        <input
                            className="form-control"
                            type="number"
                            name="rideCount"
                            min="0"
                            value={form.rideCount}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Ticket Price</label>
                        <input
                            className="form-control"
                            type="number"
                            name="ticketPrice"
                            min="0"
                            step="0.01"
                            value={form.ticketPrice}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <button
                        className="btn btn-primary me-2"
                        type="submit"
                        disabled={saving}
                    >
                        {saving
                            ? "Saving..."
                            : editingPark
                                ? "Update Park"
                                : "Add Park"}
                    </button>

                    {editingPark && (
                        <button
                            className="btn btn-secondary"
                            type="button"
                            onClick={onCancel}
                            disabled={saving}
                        >
                            Cancel
                        </button>
                    )}
                </form>
            </div>
        </div>
    );
}

export default ThemeParkForm;
