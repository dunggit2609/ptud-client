import axiosClient from "./axiosClient";

const url = "https://ptud-dotnet-server.herokuapp.com/api/Order";
const shopService = {
  create(payload) {
    return axiosClient.post(`${url}`, payload);
  },
  update(id, payload) {
    return axiosClient.put(`${url}/${id}`, payload);
  },
  getAll(payload) {
    return axiosClient.post(`${url}`, payload);
  },
  getDetail(id) {
    return axiosClient.get(`${url}/${id}`);
  },
  delete(id) {
    return axiosClient.delete(`${url}/Delete/${id}`);
  }
};

export default shopService;
