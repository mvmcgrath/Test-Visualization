import axios from 'axios'
const baseUrl = '/api/reports'

const getReports = async () => {
  const response = await axios.get(baseUrl)
  return response.data
}

export default { getReports }

