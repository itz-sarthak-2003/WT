import Contact from "./Contact";
import Home from "./Home";

function Content({ pageName }) {
    if (pageName == "Home") {


        return (
            <>
                <Home/>
            </>
        )
    }

    if (pageName == "Contact") {


        return (
            <>
                <Contact/>
            </>
        )
    }
}
export default Content;