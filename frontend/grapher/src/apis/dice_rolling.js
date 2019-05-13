import axios from 'axios';


export default axios.create({
    baseURL: '/dice/roll'
});