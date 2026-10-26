
function ThemeParkList({ parks, onEdit, onDelete, loading }) {
    if (loading) {
        return <p>Loading theme parks...</p>;
    }

    return (
        <div className="card shadow-sm">
            <div className="card-header fw-bold">
                Theme Park List
            </div>

            <div className="card-body">
                {parks.length === 0 ? (
                    <p className="text-muted mb-0">
                        No theme parks found. Add your first theme park.
                    </p>
                ) : (
                    <div className="table-responsive">
                        <table className="table table-striped table-hover align-middle">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Park Name</th>
                                    <th>Location</th>
                                    <th>Rides</th>
                                    <th>Ticket Price</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>

                            <tbody>
                                {parks.map((park) => (
                                    <tr key={park.id}>
                                        <td>{park.id}</td>
                                        <td>{park.parkName}</td>
                                        <td>{park.location}</td>
                                        <td>{park.rideCount}</td>
                                        <td>{park.ticketPrice}</td>
                                        <td>
                                            <button
                                                className="btn btn-sm btn-warning me-2 mb-1"
                                                onClick={() => onEdit(park)}
                                            >
                                                Edit
                                            </button>

                                            <button
                                                className="btn btn-sm btn-danger mb-1"
                                                onClick={() => onDelete(park.id)}
                                            >
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ThemeParkList;
