import axios from 'axios'
const baseUrl = '/api/reportClass'

const getAll = async () => {
  const response = await axios.get(baseUrl)
  return response.data
}

const getReportClassByTestCase = async (id) => {
  const response = await axios.get(`${baseUrl}/${id}`)
  return response.data
}

export default { getAll, getReportClassByTestCase }

