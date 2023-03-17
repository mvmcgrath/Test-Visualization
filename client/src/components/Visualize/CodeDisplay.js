import styled from 'styled-components'
import { useState, useEffect } from 'react'
import { Tab, Tabs } from 'react-bootstrap'

const StyledCodeDisplay = styled.div`
  width: 1200px;
  height: 650px;
  border: 3px solid white;
`

const StyledButtonDisplay = styled.div`
    gap: 50px;
`

const StyledButton = styled.button`
  font-size: 1.5rem;
  border: 3px solid white;
  border-radius: 10px;
  background-color: #0d6efd;
  padding: 10px;
  color: white;
  min-height: 80px;
  width: 340px;
  cursor: pointer;
  margin-bottom: 10px;
  margin-top: 30px;
`

const CodeDisplay = ({ classFiles, executionData, onIndexChange }) => {
  const [modifiedClassFiles, setModifiedClassFiles] = useState([])
  const [key, setKey] = useState('')

  useEffect(() => {
    if (classFiles.length !== 0 && executionData.length !== 0) {
      const newClassFiles = [...classFiles]
      var classFileToModify = newClassFiles.filter(classFile => classFile.className === executionData[0])[0]


      // This is probably too much
      const regex = `class="(fc|nc|pc)" id="L${executionData[1]}"`
      const coverageType = classFileToModify.htmlReport.match(regex)[1]
      console.log(coverageType)

      classFileToModify = { ...classFileToModify, htmlReport: classFileToModify.htmlReport.replace(`class="${coverageType}" id="L${executionData[1]}"`, `class="${coverageType} selected" id="L${executionData[1]}"`) }
      const updatedClassFiles = [ ...newClassFiles.filter(classFile => classFile.className !== classFileToModify.className), classFileToModify ]

      console.log(classFileToModify.htmlReport)
      setKey(executionData[0])
      setModifiedClassFiles(updatedClassFiles)
    }
  }, [executionData])

  const onForward = () => {
    onIndexChange(true)
  }

  const onBackward = () => {
    onIndexChange(false)
  }



  return (
    <div>
      <StyledCodeDisplay className="bg-dark">
        <Tabs
          className="mb-0"
          activeKey={key}
          onSelect={(k) => setKey(k)}
        >
          {modifiedClassFiles.map((classFile) =>
            <Tab key={classFile.reportClassId} eventKey={classFile.className} title={classFile.className.concat('.java')} >
              <div dangerouslySetInnerHTML={{ __html: classFile.htmlReport }}/>
            </Tab>
          )}
        </Tabs>
      </StyledCodeDisplay>
      <StyledButtonDisplay className="d-flex justify-content-center align-items-center">
        <StyledButton onClick={onBackward}>{'<-'}</StyledButton>
        <StyledButton onClick={onForward}>{'->'}</StyledButton>
      </StyledButtonDisplay>
    </div>
  )
}

export default CodeDisplay