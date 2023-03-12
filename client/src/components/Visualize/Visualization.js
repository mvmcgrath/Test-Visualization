import styled from 'styled-components'
import { useParams } from 'react-router-dom'
import { useState } from 'react'

import CodeDisplay from './CodeDisplay'
import TestDisplay from './TestDisplay'
import reportClassService from '../../services/reportClass'

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
  const visualizationId = useParams().visualizationId

  const [classFiles, setClassFiles] = useState([])

  const onSelect = (testCaseId) => {
    reportClassService.getAll().then(returnedClassFiles => {
      setClassFiles(returnedClassFiles.filter(classFile => classFile.testCaseId === testCaseId))
    })
  }

  return(
    <StyledPageContainer>
      <StyledDisplayContainer>
        <TestDisplay visualizationId={visualizationId} onSelect={onSelect} />
        <CodeDisplay classFiles={classFiles} />
      </StyledDisplayContainer>
    </StyledPageContainer>
  )
}

export default Visualization