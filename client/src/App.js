import styled from 'styled-components'
import { useEffect, useState } from 'react'
import reportService from './services/report'

const BodyContainer = styled.div`
  display: flex;
  justify-content: center;
  padding-top: 100px;
  color: white;
  font-size: 5rem;
`

const App = () => {
  const [lineNumbers, setLineNumbers] = useState('')

  useEffect(() => {
    reportService.getReports().then(returnedReport => {
      setLineNumbers(returnedReport)
    })
  }, [])

  return (
    <BodyContainer>
      <p>{lineNumbers}</p>
    </BodyContainer>
  )
}

export default App
