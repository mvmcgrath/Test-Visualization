import axios from 'axios'
const baseUrl = '/api/testCases'

const getAll = async () => {
  const response = await axios.get(baseUrl)
  return response.data
}

const getTestCase = async (id) => {
  const response = await axios.get(`${baseUrl}/${id}`)
  return response.data
}

export default { getAll, getTestCase }

