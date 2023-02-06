import styled from 'styled-components'

const BodyContainer = styled.div`
  display: flex;
  justify-content: center;
  padding-top: 100px;
  color: white;
  font-size: 5rem;
`

const App = () => {
  return (
    <BodyContainer>
      <p>Hi</p>
    </BodyContainer>
  )
}

export default App
