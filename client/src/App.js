import { Routes, Route, Navigate } from 'react-router-dom'
import { useState, useEffect } from 'react'

import Home from './components/Home/Home'
import Navigation from './components/Navigation'
import VisualizeHome from './components/Visualize/VisualizeHome'
import Visualization from './components/Visualize/Visualization'
import Register from './components/Register'
import Upload from './components/Upload'

import loginService from './services/login'
import reportService from './services/report'

const App = () => {
  const [user, setUser] = useState(null)

  const handleLogin = async (loginObject) => {
    const user = await loginService.login(loginObject)

    window.localStorage.setItem(
      'loggedTestUser', JSON.stringify(user)
    )

    setUser(user)
    console.log(user)
    reportService.setToken(user.token)
  }

  const handleLogout = () => {
    window.localStorage.removeItem('loggedTestUser')
    setUser(null)
  }

  useEffect(() => {
    const loggedUserJSON = window.localStorage.getItem('loggedTestUser')
    if (loggedUserJSON) {
      const user = JSON.parse(loggedUserJSON)
      setUser(user)
      reportService.setToken(user.token)
    }
  }, [])

  return (
    <div>
      <Navigation user={user} handleLogout={handleLogout}/>
      <div>
        <Routes>
          <Route path="/" element={<Home handleLogin={handleLogin} user={user}/>} />
          <Route path="/visualize" element={ user !== null ? <VisualizeHome user={user} /> : <Navigate to="/" />} />
          <Route path="/visualization/:id" element={ <Visualization user={user} />} />
          <Route path="/register" element={<Register />} />
          <Route path="/upload" element={ user !== null ? <Upload user={user}/> : <Navigate to="/" />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
