import styled from 'styled-components'
import { useParams, useNavigate } from 'react-router-dom'
import { useState } from 'react'

import CodeDisplay from './CodeDisplay'
import TestDisplay from './TestDisplay'
import reportClassService from '../../services/reportClass'
import visualService from '../../services/visual'

const StyledPageContainer = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    color: white;
`

const StyledDisplayContainer = styled.div`
    display: flex;
    justify-content: space-evenly;
    align-items: flex-start;
    margin-top: 50px;
`

const Visualization = () => {
  const navigate = useNavigate()
  const visualizationId = useParams().visualizationId

  const [classFiles, setClassFiles] = useState([])

  const onSelect = (testCaseId) => {
    reportClassService.getAll().then(returnedClassFiles => {
      setClassFiles(returnedClassFiles.filter(classFile => classFile.testCaseId === testCaseId))
    })
  }

  const onDelete = () => {
    visualService.deleteVisual(visualizationId).then(() => {
      navigate('/')
    })
  }

  return(
    <StyledPageContainer>
      <StyledDisplayContainer>
        <TestDisplay visualizationId={visualizationId} onSelect={onSelect} onDelete={onDelete} />
        <CodeDisplay classFiles={classFiles} />
      </StyledDisplayContainer>
    </StyledPageContainer>
  )
}

export default Visualization