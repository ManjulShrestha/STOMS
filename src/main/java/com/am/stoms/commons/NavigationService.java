package com.am.stoms.commons;

import com.am.stoms.utils.Console;
import java.io.IOException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author manjul.shrestha
 */
@ManagedBean(name = "navigationService")
@ApplicationScoped

public class NavigationService {

    private final String redirectText = ".xhtml";

    // Redirects to certain link
    // link doesn't require context path or faces-redirect=true
    public static void redirect(String link) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.getFlash().setKeepMessages(true);
            externalContext.redirect(externalContext.getRequestContextPath() + link);
        } catch (IOException e) {
            Console.error("Redirect unsuccessful due to ");
            Console.error(e.toString());
        }
    }

    public NavigationService() {
    }

    // For redirect using redirect()
    public String getLogin() {
        return "/Login.xhtml";
    }

    public String getPassword() {
        return "/Password.xhtml";
    }

    public String getChangePassword() {
        return "/pages/ChangePassword.xhtml";
    }

    public String getRegister() {
        return "/Register.xhtml";
    }

    public String getUser() {
        return "/pages/admin/identity/User.xhtml";
    }

    public String getResource() {
        return "/pages/admin/identity/Resource.xhtml";
    }

    public String getRole() {
        return "/pages/admin/identity/Role.xhtml";
    }

    public String getRoleGroup() {
        return "/pages/admin/identity/RoleGroup.xhtml";
    }

    public String getOrganization() {
        return "/pages/admin/metadata/Organization.xhtml";
    }

    // For Includes
    public String getBase() {
        return "/pages/global-component/Base.xhtml";
    }

    public String getHeader() {
        return "/pages/global-component/Header.xhtml";
    }

    public String getSidebar() {
        return "/pages/global-component/SideBar.xhtml";
    }

    public String getBreadcrumb() {
        return "/pages/global-component/Breadcrumb.xhtml";
    }

    public String getFooter() {
        return "/pages/global-component/Footer.xhtml";
    }

    public String getHome() {
        return "/pages/landing/Home.xhtml";
    }

    public String getForbiddenPage() {
        return "/errors/403.xhtml";
    }

    public String getPasswordResetPage(String uuid) {
        return "/Password.xhtml?uuid=" + uuid;
    }

    public String getPasswordChangePage(String uuid) {
        return "/pages/ChangePassword.xhtml";
    }

}
