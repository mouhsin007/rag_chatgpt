import {NavLink, Outlet} from "react-router-dom";

export default function Layout(){
    return(
      <div className="p-m">
          <nav>
              <NavLink className="btn p-m" to="/">Home</NavLink>
              <NavLink className="btn p-m" to="/chat">Chat</NavLink>
          </nav>
          <main>
              <Outlet></Outlet>
          </main>
      </div>
    );
}