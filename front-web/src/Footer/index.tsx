import "./styles.css";
import { ReactComponent as YouTubeIcon } from "./youtube.svg";
import { ReactComponent as LinkedIn } from "./linkedin.svg";
import { ReactComponent as Instagramcon } from "./instagram.svg";

function Footer() {
  return (
    <footer className="main-footer">
          App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
          <div className="footer-icons">
              <a href="https://www.youtube.com/c/DevSuperior" target="_new">
                <YouTubeIcon />
              </a>

              <a href="http://www.linkedin.com/school/devsuperior/" target="_new">
                <LinkedIn />
              </a>

              <a href="http://www.instagram.com/devsuperior.ig">
                <Instagramcon />
              </a>
              
               </div>
    </footer>
  );
}

export default Footer;
