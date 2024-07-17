import { Router, Route, Navigate } from '@solidjs/router'

import Home from "/src/Pages/Home"
import Login from '/src/Pages/Auth/login'
import SignUp from '/src/Pages/Auth/signup'

function App() {
  return (
    <Router>
      <Route path="/" component={() => <Navigate href="/home" />} />
      <Route path="/home" component={Home} />
      <Route path="/login" component={Login} />
      <Route path="/signup" component={SignUp} />
    </Router>
  )
}

export default App
