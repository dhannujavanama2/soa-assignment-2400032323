
const API_URL = import.meta.env.VITE_API_BASE_URL || "http://localhost:8002";

async function request(endpoint, options = {}) {
    const response = await fetch(`${API_URL}${endpoint}`, {
        ...options,
        headers: {
            "Content-Type": "application/json",
            ...options.headers
        }
    });

    if (!response.ok) {
        const message = await response.text();
        throw new Error(message || `Request failed: ${response.status}`);
    }

    if (response.status === 204) {
        return null;
    }

    const contentType = response.headers.get("content-type") || "";

    if (contentType.includes("application/json")) {
        return response.json();
    }

    return response.text();
}

const ThemeParkService = {
    // Display all theme parks
    getAll: () => request("/themepark/displayall"),

    // Display a theme park by ID
    getById: (id) => request(`/themepark/display/${id}`),

    // Add a new theme park
    add: (park) =>
        request("/themepark/add", {
            method: "POST",
            body: JSON.stringify(park)
        }),

    // Update an existing theme park
    update: (id, park) =>
        request(`/themepark/update/${id}`, {
            method: "PUT",
            body: JSON.stringify(park)
        }),

    // Delete a theme park
    delete: (id) =>
        request(`/themepark/delete/${id}`, {
            method: "DELETE"
        })
};

export default ThemeParkService;
