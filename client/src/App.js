import { Routes, Route } from 'react-router-dom'
import { useState, useEffect } from 'react'

import Home from './components/Home/Home'
import Navigation from './components/Navigation'
import VisualizeHome from './components/Visualize/VisualizeHome'
import Manage from './components/Manage/Manage'
import Register from './components/Register'

import loginService from './services/login'

const App = () => {
  const [user, setUser] = useState(null)

  const handleLogin = async (loginObject) => {
    const user = await loginService.login(loginObject)

    window.localStorage.setItem(
      'loggedImageUser', JSON.stringify(user)
    )

    setUser(user)
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

    }
  }, [])

  return (
    <div>
      <Navigation handleLogout={handleLogout}/>
      <div>
        <Routes>
          <Route path="/" element={<Home handleLogin={handleLogin} user={user}/>} />
          <Route path="/visualize" element={<VisualizeHome />} />
          <Route path="/manage" element={<Manage />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
