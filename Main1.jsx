import { useState } from "react";
import Content from "./Content";
import "./Main1.css"
function Main1(){
    let [page,setpage]=useState("Home");
    function changePage(event){
        setpage(event.target.id);      
    }
    return(
        <>
        <div className="container">
            <div className="sidebar">
                <button id="Home" onClick={changePage}>Home</button>
                <button id="Contact" onClick={changePage}>Contact</button>
            
            </div>
            <div className="maincontent">
                <Content pageName={page}/>
                
            </div>

        </div>
        </>
    )
}
export default Main1;