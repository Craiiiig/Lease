import { useEffect } from "react";

const RoomManagement = () => {
    useEffect(() => {
        console.log("Room Management component mounted");
    })
    return (
        <div>
            <h1>Room Management</h1>
            <p>Manage your apartment rooms here.</p>
           
        </div>
    );
}
export default RoomManagement;