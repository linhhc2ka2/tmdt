package web.tmdt.configs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionConfig {
    @Autowired
    HttpSession httpSession;

    public <T> T get(String name) {
        return (T) httpSession.getAttribute(name);
    }

    public void set(String name, String value) {
        httpSession.setAttribute(name, value);
    }

    public void remove(String name) {
        httpSession.removeAttribute(name);
    }

    public void invalidate() {
        httpSession.invalidate();
    }
}
