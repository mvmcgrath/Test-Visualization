import styled from 'styled-components'
import Login from './Login'

const StyledDiv = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 50px;
  align-items: center;
  gap: 50px;
`

const StyledHeader = styled.h1`
  color: white;
  font-size: 7rem;
`

const StyledEmoji = styled(StyledHeader)`
  font-size: 15rem;
`


const Home = ({ handleLogin, user }) => {
  return (
    <StyledDiv>
      <StyledHeader>Test Case Visualizer</StyledHeader>
      {user ? <StyledEmoji>🧪</StyledEmoji>
        : <Login handleLogin={handleLogin} />}
    </StyledDiv>
  )
}

export default Home