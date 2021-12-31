import Axios from 'axios';

const RESOURCE_NAME = '/api/register-shop';

export default {
    
    create(data) {
      return Axios.post(RESOURCE_NAME, data);
    },
  
    
  };