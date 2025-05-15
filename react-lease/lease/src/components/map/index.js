import L from 'leaflet';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';

// Set default icon for Leaflet markers
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconUrl: require('leaflet/dist/images/marker-icon.png'),
  iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
  shadowUrl: require('leaflet/dist/images/marker-shadow.png'),
});

const apartments = [
  { id: 1, name: 'Apartment 1', location: [-27.595075, 153.045730], address: '10 Ridings St, Sunnybank Hills' },
  { id: 2, name: 'Apartment 2', location: [-27.494479, 153.005101], address: '10 Warren St St Lucia' },
  { id: 2, name: 'Apartment 2', location: [-27.476257, 152.995611], address: '21 Mcilwraith St Auchenflower' },
  { id: 3, name: 'Unilodge Toowong', location: [-27.485955, 152.994292], address: '29 Archer ST Toowong' }
]


const LeafletMap = () => (
  <div>
    <MapContainer
      center={apartments[0].location}
      zoom={10.5}
      scrollWheelZoom={false}
      style={{ height: "400px", width: "100%" }}
    >
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      
      {apartments.map(apartment => (
        <Marker key={apartment.id} position={apartment.location}>
          <Popup>
            <div style={{ textAlign: "center" }}>
              <div>{apartment.name}</div>
              <div>{apartment.address}</div>
            </div>
          </Popup>
        </Marker>
      ))}

    </MapContainer>
  </div>
);

export default LeafletMap;
