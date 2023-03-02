import styled from 'styled-components'
import { useState } from 'react'
import reportService from '../../services/report'

const BodyContainer = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding-top: 100px;
  color: white;
  font-size: 5rem;
`

const StyledButton = styled.button`
  font-size: 1.5rem;
  border: 3px solid white;
  border-radius: 10px;
  background-color: #4b5054;
  padding: 10px;
  color: white;
  min-height: 80px;
  width: 340px;
  cursor: pointer;
  margin-bottom: 10px;
`

const Visualization = () => {
  const [lineNumbers, setLineNumbers] = useState('')

  const handleClick = (event) => {
    event.preventDefault()
    reportService.getReports().then(returnedReport => {
      setLineNumbers(returnedReport)
    })
  }

  return(
    <BodyContainer>
      <StyledButton onClick={handleClick}>Generate Report</StyledButton>
      <p>{lineNumbers}</p>
    </BodyContainer>
  )
}

export default Visualization