import axios from 'axios'
const baseUrl = '/api/reports'

let token = null

const setToken = newToken => {
  token = `Bearer ${newToken}`
}

const uploadVisual = async ( visualObject ) => {
  const config = {
    headers: { Authorization: token }
  }

  const response = await axios.post(baseUrl, visualObject, config)
  return response.data
}

const getReports = async () => {
  const response = await axios.get(baseUrl)
  return response.data
}



export default { setToken, uploadVisual, getReports }

