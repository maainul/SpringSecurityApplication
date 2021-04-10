# For running this Application Follow this steps:

1. create database in mysql "ssApp"
2. Update application.properties with valid mysql username and password
3. Go to http://localhost:8080/register for Register new User
4. Go to Gmail and verify your email
5. Go to Login page http://localhost:8080/login give username and password.
6. ENJOY !!!!

# Login Screen

http://localhost:8080/login

![Screenshot from 2021-03-30 23-34-15](https://user-images.githubusercontent.com/37740006/113031555-ac8b1600-91b0-11eb-899c-97b62559bc51.png)

# Reigstration Screen:

http://localhost:8080/register

![Screenshot from 2021-03-30 23-34-18](https://user-images.githubusercontent.com/37740006/113031703-d6dcd380-91b0-11eb-9281-b76708fa4f6d.png)

# Index Page:

http://localhost:8080/
![Screenshot from 2021-03-30 23-34-25](https://user-images.githubusercontent.com/37740006/113031826-f8d65600-91b0-11eb-88de-e43421185953.png)

# ---------------------------------------------------------------------------

# 1. STEP -1

# ---------------------------------------------------------------------------

![springSecurity1](https://user-images.githubusercontent.com/37740006/114138178-1339cd80-992f-11eb-9cdb-e7c01ea352f7.png)

# 1. Create Project from SpringInitializer

# 2. Add Dependencies

    1. springboot devtools
    2. Spring boot security

```xml

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
     <groupId>org.thymeleaf.extras</groupId>
     <artifactId>thymeleaf-extras-springsecurity5</artifactId>
  </dependency>
  <dependency>
     <groupId>org.springframework.boot</groupId>
	 <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>  
```
# 3. Create Controller,index.html

# HomeController:

```java
package com.SpringSecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class HomeController {

    @GetMapping("/home")
    public String getHome() {
        return "index";
    }

}
```

# Index.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head th:replace="core/head :: head">
    <meta charset="utf-8">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!--<header th:replace="core/header :: header">
    </header> -->
    <nav th:replace="core/userProfile :: nav"></nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index.html" class="brand-link">
            <span class="brand-text font-weight-light">Spring Security App</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                    <a href="https://github.com/maainul/SpringSecurityApplication" class="d-block">Github Link</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item has-treeview menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                Dashboard
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Dashboard v1</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Dashboard v2</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="pages/widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Customers
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>
                                Orders
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tree"></i>
                            <p>
                                Layout
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                My Account
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                Payments
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">Weclome</h1>
                    </div>
                    <!-- /.col -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header"><h3 class="card-title">Your Active Sessions</h3>

                    </div>
                    <!-- /.card-header -->
                    <div class="card-body table-responsive p-0">
                        <table class="table table-hover text-nowrap">
                            <thead>
                            <tr>
                                <th>Session ID</th>
                                <th>Last Used</th>
                                <th>Logout</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr th:each="activesession : ${currentSession}">
                                <td th:text="${activesession.sessionId}"></td>
                                <td th:text="${#calendars.format(activesession.lastRequest, 'yyyy-MM-dd HH:mm')}"></td>
                                <td>11-7-2014</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
        </div>
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
</div>
<!-- /.col-md-6 -->
</div>
<!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->

<!-- Main Footer -->
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script th:src="@{/plugins/jquery/jquery.min.js}"></script>
<!-- Bootstrap -->
<script th:src="@{/plugins/bootstrap/js/bootstrap.bundle.min.js}"></script>
<!-- AdminLTE -->
<script th:src="@{/dist/js/adminlte.min.js}"></script>

<script th:src="@{/dist/js/pages/dashboard3.js}"></script>
</body>
</html>

```

# Run The Project

### http://localhost:8080/

![ s2](https://user-images.githubusercontent.com/37740006/114138259-32385f80-992f-11eb-80fb-1080c22875db.png)

# ---------------------------------------------------------------------------

# 1. STEP -2

# ---------------------------------------------------------------------------

# Create packages

1. config
2. security.core.userdetail
3. system.exception
4. user
5. web

# This is WebSecurity Basic Code

This will allow only you give the user name and password. After giving user name and password you are able to perform
any operation

```java
    @Override
protected void configure(HttpSecurity http)throws Exception{
        http
        .authorizeRequests()
        .anyRequest().authenticated()
        .formLogin().and()
        .httpBasic();
```

.antMatchers() - gives you new Dimension to add new expression for security configuration

.antMatchers("/login","/register") - I want login and register Outside of the authentication process

.antMatchers("/login","/register").permitAll()

.antMatchers("/account/**").hasAuthority("USER") - Only Authenticated Person can access these url.USER is Role

.antMatchers("/account/**").hasAnyAuthority("USER","SPECIALUSER","CUSTOMER") - Only Authenticated Person can access
these url.USER,Customer is Role

```java
    @Override
protected void configure(HttpSecurity http)throws Exception{
          	http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/login","/register").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/account/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();

```

# Create AppSecurityConfig in security/AppSecurityConfig

```java
package com.SpringSecurityApp.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/login","/register").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/account/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();

    }
}
```

# Create data/user/UserData

```java
package com.SpringSecurityApp.data.user;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1707314627545523673L;

	@NotEmpty(message = "First name can not be empty")
	private String firstName;

	@NotEmpty(message = "Last name can not be empty")
	private String lastName;

	@NotEmpty(message = "Email can not be empty")
	@Email(message = "Please provide a valid email id")
	private String email;

	@NotEmpty(message = "Password can not be empty")
	private String password;

	public UserData() {

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
}



```

# Create RegistrationController

```java
package com.SpringSecurityApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String register(final Model model) {
        model.addAttribute("userData", new UserData());
        return "account/register";
    }
}
```

# create Account/register.html in template folder

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head th:replace="core/head :: head">
    <meta charset="utf-8">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="#">Welcome to Spring Security App</a>
    </div>
    <div class="card">
        <div class="card-body register-card-body">
            <div class="alert alert-success" role="alert"
                 th:if="${registrationMsg != null}">
                <p th:text="${registrationMsg}"></p>
            </div>
            <p class="login-box-msg">Register a new account</p>
            <form action="#" th:action="@{/register}" th:object="${userData}"
                  method="post">
                <div class="alert alert-danger" th:if="${#fields.hasErrors('*')}">
                    <p th:each="err : ${#fields.errors('*')}" th:text="${err}"></p>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" th:field="*{firstName}"
                           placeholder="First Name" th:errorclass="is-invalid">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" th:field="*{lastName}"
                           placeholder="Last Name" th:errorclass="is-invalid">

                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="email" class="form-control" th:field="*{email}"
                           placeholder="Email" th:errorclass="is-invalid">

                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" th:field="*{password}"
                           placeholder="Password" th:errorclass="is-invalid">

                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control"
                           placeholder="Retype password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="agreeTerms" name="terms"
                                   value="agree"> <label for="agreeTerms"> I agree
                            to the <a href="#">terms</a>
                        </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <a href="login" class="text-center">I already have an Account</a>
        </div>
        <!-- /.form-box -->
    </div>
    <!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script th:src="@{/plugins/jquery/jquery.min.js}"></script>
<!-- Bootstrap 4 -->
<script th:src="@{/plugins/bootstrap/js/bootstrap.bundle.min.js}"></script>
<!-- AdminLTE App -->
<script th:src="@{/dist/js/adminlte.min.js}"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("#locale").change(function() {
				var selectedOption = $('#locale').val();
				if (selectedOption != '') {
					window.location.replace('?lang=' + selectedOption);
				}
			});
		});
	




</script>
</body>
</html>
```

# Create core.head.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head th:fragment="head">
    <meta charset="utf-8">
    <!-- Test it -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Java Dev Journal | Registration Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" th:href="@{/plugins/fontawesome-free/css/all.min.css}">
    <!-- Ionicons
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
    <!-- icheck bootstrap -->
    <link rel="stylesheet" th:href="@{/plugins/icheck-bootstrap/icheck-bootstrap.min.css}">
    <!-- Theme style -->
    <link rel="stylesheet" th:href="@{/dist/css/adminlte.min.css}">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

</head>
```

# Create core.header.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<header th:fragment="header" class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu"><a href="#"
                                                      class="dropdown-toggle" data-toggle="dropdown"> <i
                        class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
                </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 4 messages</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li>
                                    <!-- start message --> <a href="#">
                                    <div class="pull-left">
                                        <img src="dist/img/user2-160x160.jpg" class="img-circle"
                                             alt="User Image">
                                    </div>
                                    <h4>
                                        Support Team <small><i class="fa fa-clock-o"></i> 5
                                        mins</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                                </li>
                                <!-- end message -->
                                <li><a href="#">
                                    <div class="pull-left">
                                        <img src="dist/img/user3-128x128.jpg" class="img-circle"
                                             alt="User Image">
                                    </div>
                                    <h4>
                                        AdminLTE Design Team <small><i class="fa fa-clock-o"></i>
                                        2 hours</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a></li>
                                <li><a href="#">
                                    <div class="pull-left">
                                        <img src="dist/img/user4-128x128.jpg" class="img-circle"
                                             alt="User Image">
                                    </div>
                                    <h4>
                                        Developers <small><i class="fa fa-clock-o"></i> Today</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a></li>
                                <li><a href="#">
                                    <div class="pull-left">
                                        <img src="dist/img/user3-128x128.jpg" class="img-circle"
                                             alt="User Image">
                                    </div>
                                    <h4>
                                        Sales Department <small><i class="fa fa-clock-o"></i>
                                        Yesterday</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a></li>
                                <li><a href="#">
                                    <div class="pull-left">
                                        <img src="dist/img/user4-128x128.jpg" class="img-circle"
                                             alt="User Image">
                                    </div>
                                    <h4>
                                        Reviewers <small><i class="fa fa-clock-o"></i> 2 days</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a></li>
                            </ul>
                        </li>
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <!-- Notifications: style can be found in dropdown.less -->
                <li class="dropdown notifications-menu"><a href="#"
                                                           class="dropdown-toggle" data-toggle="dropdown"> <i
                        class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
                </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 10 notifications</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><a href="#"> <i class="fa fa-users text-aqua"></i>
                                    5 new members joined today
                                </a></li>
                                <li><a href="#"> <i class="fa fa-warning text-yellow"></i>
                                    Very long description here that may not fit into the page and
                                    may cause design problems
                                </a></li>
                                <li><a href="#"> <i class="fa fa-users text-red"></i> 5
                                    new members joined
                                </a></li>
                                <li><a href="#"> <i
                                        class="fa fa-shopping-cart text-green"></i> 25 sales made
                                </a></li>
                                <li><a href="#"> <i class="fa fa-user text-red"></i>
                                    You changed your username
                                </a></li>
                            </ul>
                        </li>
                        <li class="footer"><a href="#">View all</a></li>
                    </ul>
                </li>
                <!-- Tasks: style can be found in dropdown.less -->
                <li class="dropdown tasks-menu"><a href="#"
                                                   class="dropdown-toggle" data-toggle="dropdown"> <i
                        class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
                </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 9 tasks</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li>
                                    <!-- Task item --> <a href="#">
                                    <h3>
                                        Design some buttons <small class="pull-right">20%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-aqua"
                                             style="width: 20%" role="progressbar" aria-valuenow="20"
                                             aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </a>
                                </li>
                                <!-- end task item -->
                                <li>
                                    <!-- Task item --> <a href="#">
                                    <h3>
                                        Create a nice theme <small class="pull-right">40%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-green"
                                             style="width: 40%" role="progressbar" aria-valuenow="20"
                                             aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">40% Complete</span>
                                        </div>
                                    </div>
                                </a>
                                </li>
                                <!-- end task item -->
                                <li>
                                    <!-- Task item --> <a href="#">
                                    <h3>
                                        Some task I need to do <small class="pull-right">60%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-red" style="width: 60%"
                                             role="progressbar" aria-valuenow="20" aria-valuemin="0"
                                             aria-valuemax="100">
                                            <span class="sr-only">60% Complete</span>
                                        </div>
                                    </div>
                                </a>
                                </li>
                                <!-- end task item -->
                                <li>
                                    <!-- Task item --> <a href="#">
                                    <h3>
                                        Make beautiful transitions <small class="pull-right">80%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-yellow"
                                             style="width: 80%" role="progressbar" aria-valuenow="20"
                                             aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                                </li>
                                <!-- end task item -->
                            </ul>
                        </li>
                        <li class="footer"><a href="#">View all tasks</a></li>
                    </ul>
                </li>
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu"><a href="#"
                                                       class="dropdown-toggle" data-toggle="dropdown"> <img
                        src="dist/img/user2-160x160.jpg" class="user-image"
                        alt="User Image"> <span class="hidden-xs">Alexander
							Pierce</span>
                </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header"><img src="dist/img/user2-160x160.jpg"
                                                     class="img-circle" alt="User Image">

                            <p>
                                Alexander Pierce - Web Developer <small>Member since
                                Nov. 2012</small>
                            </p></li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </div> <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profile</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li><a href="#" data-toggle="control-sidebar"><i
                        class="fa fa-gears"></i></a></li>
            </ul>
        </div>

    </nav>
</header>
```

# Create core.userProfile.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" data-widget="pushmenu"
                                href="#" role="button"><i class="fas fa-bars"></i></a></li>
        <li class="nav-item d-none d-sm-inline-block"><a
                href="index.html" class="nav-link">Home</a></li>
        <li class="nav-item d-none d-sm-inline-block"><a href="#"
                                                         class="nav-link">Contact</a></li>

    </ul>

    <ul class="navbar-nav ml-auto">
        <li class="dropdown user user-menu"
            sec:authorize="hasAuthority('USER')"><a href="#"
                                                    class="dropdown-toggle" data-toggle="dropdown"
                                                    aria-expanded="false">
            <span class="hidden-xs" sec:authentication="name"></span>
        </a>
            <ul class="dropdown-menu">
                <li class="user-header"><img th:src="@{/dist/img/avatar5.png}"
                                             class="img-circle" alt="User Image">

                    <p>
                        Spring Security App <small>Java Development Application</small>
                    </p></li>

                <div sec:authorize="isAuthenticated()"></div>
                <li class="user-footer">
                    <div class="pull-right">
                        <a href="javascript: document.logoutForm.submit()"
                           class="btn btn-default btn-flat">Sign out</a>
                        <form name="logoutForm" th:action="@{/logout}" method="post"
                              th:hidden="true">
                            <input hidden type="submit" value="Sign Out"/>
                        </form>
                    </div>
                </li>
                </li>
            </ul>
</nav>
```

## http://localhost:8080/register

![register](https://user-images.githubusercontent.com/37740006/114150364-ca3d4580-993d-11eb-8c76-e0d88c044121.png)

Any other Url is not available only register and login available

![ s2](https://user-images.githubusercontent.com/37740006/114138259-32385f80-992f-11eb-80fb-1080c22875db.png)

# There are 3 Type of Authentication Provider

1. Inmemory Authentication
2. JDBC Based Authentication
2. DaoAuthentication Provider

## 1. InMemory Authentication:

Hardcoded authentication in a method for authenticating a User. Suppose you want admin role password is admin1234 then
code will be for InMemory Authentication is:

```java
@Override
public void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}admin12345")
        .authorities("USER");
        }
```

# Update AppSecurityConfig.java

```java
package com.SpringSecurityApp.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/account/**").hasAuthority("USER")
                .formLogin().and()
                .httpBasic();

        @Override
        public void configure (AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("{noop}admin12345")
                    .authorities("USER");
        }
    }
```

## Type http://localhost:8080/

![ s2](https://user-images.githubusercontent.com/37740006/114138259-32385f80-992f-11eb-80fb-1080c22875db.png)

# Let's Create User Registration Process

#### Add Following Dependencies in the pom

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<scope>runtime</scope>
</dependency>

<dependency>
<groupId>org.thymeleaf.extras</groupId>
<artifactId>thymeleaf-extras-springsecurity5</artifactId>
</dependency>

```

# Create register.html page

# Create UserData Model

```java
package com.SpringSecurityApp.data.user;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserData implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1707314627545523673L;

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;

    public UserData() {

    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + "]";
    }
}

```

# Create RegisterController

```java
package com.SpringSecurityApp.controller.user;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.service.UserService;


@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String register(final Model model) {
        model.addAttribute("userData", new UserData());
        return "account/register";
    }

    @PostMapping
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult,
                                   final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        try {
            userService.register(userData);
        } catch (UserAlreadyExistException e) {
            bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        return REDIRECT + "account/starter";
    }


}
```

# Create UserEntity

```java
package com.SpringSecurityApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SpringSecurityApp.security.jpa.SecureToken;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}

```

# Create message.properties For Bean validation API

```java
lang.eng=English
        lang.de=German
        registration.validation.firstName=Please provide first name
        registration.validation.lastName=Please provide last name
        registration.validation.email=Please provide a valid email
        registration.validation.password=Password can not be empty
        login.error=Username or password is incorrect.Please make sure to provide valid username or password.

        user.registration.verification.missing.token=Token is empty.Please make sure to copy the entire URL
        user.registration.verification.invalid.token=It seems that token is expired or has been modified.Please provide a valid token.
        user.registration.verification.success=Thanks for the account verification.You can now login to your account.
        user.registration.verification.email.msg=Thanks for your registration.We have sent a verification email.Please verify your account.
        user.forgotpwd.msg=If the email address entered matches your account,you will receive an email with a link to reset your password.
        user.password.updated.msg=Your password is updated.Please login
```

# Creaate Repository UserRepository.java

```java
package com.SpringSecurityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurityApp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}

```

# Create UserService.java

```java
package com.SpringSecurityApp.service;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UnkownIdentifierException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;


public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;

    boolean checkIfUserExist(final String email);


}

```

# UserService.java

```java
package com.SpringSecurityApp.service.impl;

import java.util.Objects;

import javax.mail.MessagingException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.context.AccountVerificationEmailContext;
import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UnkownIdentifierException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.SecureTokenRepository;
import com.SpringSecurityApp.repository.UserRepository;
import com.SpringSecurityApp.security.jpa.SecureToken;
import com.SpringSecurityApp.service.EmailService;
import com.SpringSecurityApp.service.SecureTokenService;
import com.SpringSecurityApp.service.UserService;

@Service("userService")

public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${site.base.url.https}")
    private String baseURL;

    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(user, target);
        userRepository.save(userEntity);

    }

    private void encodePassword(UserData source, UserEntity target) {
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

}
```

# Update RegisterController

```java
package com.SpringSecurityApp.controller.user;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.service.UserService;


@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final String REDIRECT_LOGIN = "redirect:/login";

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String register(final Model model) {
        model.addAttribute("userData", new UserData());
        return "account/register";
    }

    @PostMapping
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult,
                                   final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        try {
            userService.register(userData);
        } catch (UserAlreadyExistException e) {
            bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        return REDIRECT + "account/starter";
    }
}
```

# Try To Add new Registration

### http://localhost:8080/register

![registration](https://user-images.githubusercontent.com/37740006/114256523-a03a6080-99db-11eb-9b37-dbc907747eb7.png)

# ------------------------------------------------------------------------------------------------

# STEP -4

# ------------------------------------------------------------------------------------------------

In this Steps We will Learn:

1. Custom login page
2. Custom login Controller
3. Defining the custom user details Service
4. Configuring the DAOAuthentication Provider
5. Login Demo

![loginWorkflow](https://user-images.githubusercontent.com/37740006/114256668-bf85bd80-99dc-11eb-8360-51d0b584f4e2.png)

# Create Login Page (account/login.html file)

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head th:replace="core/head :: head">
    <meta charset="utf-8">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#">Welcome to Spring Security Application</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">Sign in to start your session</p>
            <p th:if="${loginError}" class="error"></p>
            <form th:action="@{/login}" method="post">
                <div th:if="${param.error}">
                    <div class="alert alert-danger">
                        <span th:text="#{login.error}"/>
                    </div>

                </div>
                <div class="input-group mb-3">
                    <input type="email" class="form-control" name="username"
                           placeholder="Email" autocomplete=”off”>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" name="password" class="form-control"
                           placeholder="Password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember" name="remember-me">
                            <label for="remember"> Remember Me </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Sign
                            In
                        </button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center mb-3">
                <p>- OR -</p>
                <a href="#" class="btn btn-block btn-primary"> <i
                        class="fab fa-facebook mr-2"></i> Sign in using Facebook
                </a> <a href="#" class="btn btn-block btn-danger"> <i
                    class="fab fa-google-plus mr-2"></i> Sign in using Google+
            </a>
            </div>
            <!-- /.social-auth-links -->

            <p class="mb-1">
                <a href="#" data-toggle="modal" data-target="#forgotPasswordModel">I
                    forgot my password</a>
            </p>
            <p class="mb-0">
                <a href="register" class="text-center">Register a new
                    membership</a>
            </p>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<div th:replace="account/forgotPassword :: forgotPasswordModel"></div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<script src="../../plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("#locale").change(function() {
				var selectedOption = $('#locale').val();
				if (selectedOption != '') {
					window.location.replace('?lang=' + selectedOption);
				}
			});
		});
	

</script>
</body>
</html>
```

# Create LoginController

```java
package com.SpringSecurityApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "account/login";
    }
}
```

# Update AppSecurityConfig.java

```java
package com.SpringSecurityApp.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/account/**").hasAuthority("USER")
                .and()
                .formLogin(form -> form
                        .defaultSuccessUrl("/account/home")
                        .loginPage("/login")
                        .failureUrl("/login?error=true"));

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**", "/static/**");
    }

}
```

# Let's Load the User Information for validating the user is Exists or not?

# Create CustomUserDetailService

```java
package com.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final UserEntity customer = userRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }
       
        UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword())
                .authorities("USER").build();
        return user;
    }
}

```

## Which Authentication provider is used to authenticate the user ? We will be using authentication provider

```java
@Bean
public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        }

@Bean
public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
        }

@Override
protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
        }

```


# Complete Code for AppSecurityConfig.java

```java
package com.SpringSecurityApp.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/account/**").hasAuthority("USER")
                .and()
                .formLogin(form -> form
                        .defaultSuccessUrl("/account/home")
                        .loginPage("/login")
                        .failureUrl("/login?error=true"));

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**", "/static/**");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }
}
```
## http://localhost:8080/login
# Done REGISTRATION AND LOGIN
# -----------------------------------------------------------------
# STEP -5 ( EMAIL VERIFICATION REGISTRATION)
# -----------------------------------------------------------------
# Create Field is in UserEntity
```java
private boolean accountVerified;
```
# Complete code for UserEntity
```java
package com.SpringSecurityApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SpringSecurityApp.security.jpa.SecureToken;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private boolean accountVerified;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the accountVarified
	 */
	public boolean isAccountVerified() {
		return accountVerified;
	}

	/**
	 * @param accountVarified the accountVarified to set
	 */
	public void setAccountVerified(boolean accountVerified) {
		this.accountVerified = accountVerified;
	}
}

```
# Update CustomUserDetailService
```java
boolean enabled = !customer.isAccountVerified();
		UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword()).disabled(enabled)
				.authorities("USER").build();
```
# Complete Code for CustomerDetailService

```java
package com.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final UserEntity customer = userRepository.findByEmail(email);
		if (customer == null) {
			throw new UsernameNotFoundException(email);
		}
		boolean enabled = !customer.isAccountVerified();
		UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword()).disabled(enabled)
				.authorities("USER").build();
		return user;
	}
}
```
# Create SecureToken Class for Sending Email to the User
# Create package security/jpa/SecureToken.java
```java
package com.SpringSecurityApp.security.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import com.SpringSecurityApp.entity.UserEntity;

@Entity
@Table(name = "secureTokens")
public class SecureToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String token;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp timeStamp;

	@Column(updatable = false)
	@Basic(optional = false)
	private LocalDateTime expireAt;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private UserEntity user;

	@Transient
	private boolean isExpired;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the expireAt
	 */
	public LocalDateTime getExpireAt() {
		return expireAt;
	}

	/**
	 * @param expireAt the expireAt to set
	 */
	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}

	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * @return the isExpired
	 */
	public boolean isExpired() {
		return getExpireAt().isBefore(LocalDateTime.now()); // this is generic implementation, you can always make it
															// timezone specific
	}

	/**
	 * @param isExpired the isExpired to set
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	@Override
	public String toString() {
		return "SecureToken [id=" + id + ", token=" + token + ", timeStamp=" + timeStamp + ", expireAt=" + expireAt
				+ ", user=" + user + ", isExpired=" + isExpired + "]";
	}

}
```
# Create One to Many RelationShip to the User
# Update UserEntity
```java
package com.SpringSecurityApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.SpringSecurityApp.security.jpa.SecureToken;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private boolean accountVerified;

	@OneToMany(mappedBy = "user")
	private Set<SecureToken> tokens;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the accountVarified
	 */
	public boolean isAccountVerified() {
		return accountVerified;
	}

	/**
	 * @param accountVarified the accountVarified to set
	 */
	public void setAccountVerified(boolean accountVerified) {
		this.accountVerified = accountVerified;
	}

	/**
	 * @return the tokens
	 */
	public Set<SecureToken> getTokens() {
		return tokens;
	}

	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(Set<SecureToken> tokens) {
		this.tokens = tokens;
	}

}

```
# Update DefaultUserService

```java
	@Override
	public void sendRegistrationConfirmationEmail(UserEntity user) {
}
```
1. Generate A Token
2. Save token
3. Send out email to the Customer
# For saving and removing toke Create SecureTokenRepository
# Create Folder on repository/SecureTokenRepository
```java
package com.SpringSecurityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurityApp.security.jpa.SecureToken;

@Repository
public interface SecureTokenRepository extends JpaRepository<SecureToken, Long> {
	
	SecureToken findByToken(final String token);
	Long removeByToken(String token);
}

```
After Succesfull Registration (verification of email) remove the token from the database
# Create DefaultSecureTokenService
# Create token based on certain Algorithm
```java
    @Override
    public SecureToken createSecureToken(){
        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII); // this is a sample, you can adapt as per your security need
        SecureToken secureToken = new SecureToken();
        secureToken.setToken(tokenValue);
        secureToken.setExpireAt(LocalDateTime.now().plusSeconds(getTokenValidityInSeconds()));
        this.saveSecureToken(secureToken);
        return secureToken;
    }
@Override
public void saveSecureToken(SecureToken token) {
        secureTokenRepository.save(token);
        }

@Override
public SecureToken findByToken(String token) {
        return secureTokenRepository.findByToken(token);
        }

@Override
public void removeToken(SecureToken token) {
        secureTokenRepository.delete(token);
        }

@Override
public void removeTokenByToken(String token) {
        secureTokenRepository.removeByToken(token);
        }

```
# Complete code for DefaultSecureTokenService
```java
package com.SpringSecurityApp.service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.repository.SecureTokenRepository;
import com.SpringSecurityApp.security.jpa.SecureToken;

@Service
public class DefaultSecureTokenService implements SecureTokenService {

    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Value("${jdj.secure.token.validity}")
    private int tokenValidityInSeconds;

    @Autowired
    SecureTokenRepository secureTokenRepository;

    @Override
    public SecureToken createSecureToken(){
        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII); // this is a sample, you can adapt as per your security need
        SecureToken secureToken = new SecureToken();
        secureToken.setToken(tokenValue);
        secureToken.setExpireAt(LocalDateTime.now().plusSeconds(getTokenValidityInSeconds()));
        this.saveSecureToken(secureToken);
        return secureToken;
    }

    @Override
    public void saveSecureToken(SecureToken token) {
        secureTokenRepository.save(token);
    }

    @Override
    public SecureToken findByToken(String token) {
        return secureTokenRepository.findByToken(token);
    }

    @Override@Override
	public void sendRegistrationConfirmationEmail(UserEntity user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken);
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
    public void removeToken(SecureToken token) {
        secureTokenRepository.delete(token);
    }

    @Override
    public void removeTokenByToken(String token) {
        secureTokenRepository.removeByToken(token);
    }

    public int getTokenValidityInSeconds() {
        return tokenValidityInSeconds;
    }
}
```
# Now Update DefaultUserService
```java
@Override
	public void sendRegistrationConfirmationEmail(UserEntity user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken); // created and save token
		// part 2 for send email and veriry
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
```
# Add Dependency to pom.xml
```xml

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
```
# For Sending Mail Create DefaultMailService
```java
package com.SpringSecurityApp.service.impl;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.SpringSecurityApp.context.AbstractEmailContext;
import com.SpringSecurityApp.service.EmailService;

@Service
public class DefaultEmailService implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

    @Override
    public void sendMail(AbstractEmailContext email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(email.getContext());
        String emailContent = templateEngine.process(email.getTemplateLocation(), context);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setText(emailContent, true);
        emailSender.send(message);
    }

}

```
# Create context/AbstractEmailContext.java
```java
package com.SpringSecurityApp.context;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEmailContext {
	private String from;
	private String to;
	private String subject;
	private String email;
	private String attachment;
	private String fromDisplayName;
	private String emailLanguage;
	private String displayName;
	private String templateLocation;
	private Map<String, Object> context;

	public AbstractEmailContext() {
		this.context = new HashMap<>();
	}

	public <T> void init(T context) {
		// we can do any common configuration setup here
		// like setting up some base URL and context
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the fromDisplayName
	 */
	public String getFromDisplayName() {
		return fromDisplayName;
	}

	/**
	 * @param fromDisplayName the fromDisplayName to set
	 */
	public void setFromDisplayName(String fromDisplayName) {
		this.fromDisplayName = fromDisplayName;
	}

	/**
	 * @return the emailLanguage
	 */
	public String getEmailLanguage() {
		return emailLanguage;
	}

	/**
	 * @param emailLanguage the emailLanguage to set
	 */
	public void setEmailLanguage(String emailLanguage) {
		this.emailLanguage = emailLanguage;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the templateLocation
	 */
	public String getTemplateLocation() {
		return templateLocation;
	}

	/**
	 * @param templateLocation the templateLocation to set
	 */
	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}

	/**
	 * @return the context
	 */
	public Map<String, Object> getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public Object put(String key, Object value) {
		return key == null ? null : this.context.put(key.intern(), value);
	}
}

```
# create emails/email-verification.html
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns="http://www.w3.org/1999/xhtml"
	xmlns:v="urn:schemas-microsoft-com:vml"
	xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta charset="utf-8">
<!-- utf-8 works for most cases -->
<meta name="viewport" content="width=device-width">
<!-- Forcing initial-scale shouldn't be necessary -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Use the latest (edge) version of IE rendering engine -->
<meta name="x-apple-disable-message-reformatting">
<!-- Disable auto-scale in iOS 10 Mail entirely -->
<title></title>
<!-- The title tag shows in email notifications, like Android 4.4. -->

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">

<!-- CSS Reset : BEGIN -->
<style>

/* What it does: Remove spaces around the email design added by some email clients. */
/* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */
html, body {
	margin: 0 auto !important;
	padding: 0 !important;
	height: 100% !important;
	width: 100% !important;
	background: #f1f1f1;
}

/* What it does: Stops email clients resizing small text. */
* {
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%;
}

/* What it does: Centers email on Android 4.4 */
div[style*="margin: 16px 0"] {
	margin: 0 !important;
}

/* What it does: Stops Outlook from adding extra spacing to tables. */
table, td {
	mso-table-lspace: 0pt !important;
	mso-table-rspace: 0pt !important;
}

/* What it does: Fixes webkit padding issue. */
table {
	border-spacing: 0 !important;
	border-collapse: collapse !important;
	table-layout: fixed !important;
	margin: 0 auto !important;
}

/* What it does: Uses a better rendering method when resizing images in IE. */
img {
	-ms-interpolation-mode: bicubic;
}

/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */
a {
	text-decoration: none;
}

/* What it does: A work-around for email clients meddling in triggered links. */
*[x-apple-data-detectors], /* iOS */ .unstyle-auto-detected-links *,
	.aBn {
	border-bottom: 0 !important;
	cursor: default !important;
	color: inherit !important;
	text-decoration: none !important;
	font-size: inherit !important;
	font-family: inherit !important;
	font-weight: inherit !important;
	line-height: inherit !important;
}

/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */
.a6S {
	display: none !important;
	opacity: 0.01 !important;
}

/* What it does: Prevents Gmail from changing the text color in conversation threads. */
.im {
	color: inherit !important;
}

/* If the above doesn't work, add a .g-img class to any image in question. */
img.g-img+div {
	display: none !important;
}

/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */
/* Create one of these media queries for each additional viewport size you'd like to fix */

/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */
@media only screen and (min-device-width: 320px) and (max-device-width:
	374px) {
	u ~ div .email-container {
		min-width: 320px !important;
	}
}
/* iPhone 6, 6S, 7, 8, and X */
@media only screen and (min-device-width: 375px) and (max-device-width:
	413px) {
	u ~ div .email-container {
		min-width: 375px !important;
	}
}
/* iPhone 6+, 7+, and 8+ */
@media only screen and (min-device-width: 414px) {
	u ~ div .email-container {
		min-width: 414px !important;
	}
}
</style>

<!-- CSS Reset : END -->

<!-- Progressive Enhancements : BEGIN -->
<style>
.primary {
	background: #30e3ca;
}

.bg_white {
	background: #ffffff;
}

.bg_light {
	background: #fafafa;
}

.bg_black {
	background: #000000;
}

.bg_dark {
	background: rgba(0, 0, 0, .8);
}

.email-section {
	padding: 2.5em;
}

/*BUTTON*/
.btn {
	padding: 10px 15px;
	display: inline-block;
}

.btn.btn-primary {
	border-radius: 5px;
	background: #30e3ca;
	color: #ffffff;
}

.btn.btn-white {
	border-radius: 5px;
	background: #ffffff;
	color: #000000;
}

.btn.btn-white-outline {
	border-radius: 5px;
	background: transparent;
	border: 1px solid #fff;
	color: #fff;
}

.btn.btn-black-outline {
	border-radius: 0px;
	background: transparent;
	border: 2px solid #000;
	color: #000;
	font-weight: 700;
}

h1, h2, h3, h4, h5, h6 {
	font-family: 'Lato', sans-serif;
	color: #000000;
	margin-top: 0;
	font-weight: 400;
}

body {
	font-family: 'Lato', sans-serif;
	font-weight: 400;
	font-size: 15px;
	line-height: 1.8;
	color: rgba(0, 0, 0, .4);
}

a {
	color: #30e3ca;
}

table {
	
}
/*LOGO*/
.logo h1 {
	margin: 0;
}

.logo h1 a {
	color: #30e3ca;
	font-size: 24px;
	font-weight: 700;
	font-family: 'Lato', sans-serif;
}

/*HERO*/
.hero {
	position: relative;
	z-index: 0;
}

.hero .text {
	color: rgba(0, 0, 0, .3);
}

.hero .text h2 {
	color: #000;
	font-size: 40px;
	margin-bottom: 0;
	font-weight: 400;
	line-height: 1.4;
}

.hero .text h3 {
	font-size: 24px;
	font-weight: 300;
}

.hero .text h2 span {
	font-weight: 600;
	color: #30e3ca;
}

/*HEADING SECTION*/
.heading-section {
	
}

.heading-section h2 {
	color: #000000;
	font-size: 28px;
	margin-top: 0;
	line-height: 1.4;
	font-weight: 400;
}

.heading-section .subheading {
	margin-bottom: 20px !important;
	display: inline-block;
	font-size: 13px;
	text-transform: uppercase;
	letter-spacing: 2px;
	color: rgba(0, 0, 0, .4);
	position: relative;
}

.heading-section .subheading::after {
	position: absolute;
	left: 0;
	right: 0;
	bottom: -10px;
	content: '';
	width: 100%;
	height: 2px;
	background: #30e3ca;
	margin: 0 auto;
}

.heading-section-white {
	color: rgba(255, 255, 255, .8);
}

/* .heading-section-white h2 {
	font-family: 
	line-height:1;
	padding-bottom: 0;
}
 */
.heading-section-white h2 {
	color: #ffffff;
}

.heading-section-white .subheading {
	margin-bottom: 0;
	display: inline-block;
	font-size: 13px;
	text-transform: uppercase;
	letter-spacing: 2px;
	color: rgba(255, 255, 255, .4);
}

ul.social {
	padding: 0;
}

ul.social li {
	display: inline-block;
	margin-right: 10px;
}

/*FOOTER*/
.footer {
	border-top: 1px solid rgba(0, 0, 0, .05);
	color: rgba(0, 0, 0, .5);
}

.footer .heading {
	color: #000;
	font-size: 20px;
}

.footer ul {
	margin: 0;
	padding: 0;
}

.footer ul li {
	list-style: none;
	margin-bottom: 10px;
}

.footer ul li a {
	color: rgba(0, 0, 0, 1);
}

@media screen and (max-width: 500px) {
}
</style>


</head>

<body width="100%"
	style="margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #f1f1f1;">
	<center style="width: 100%; background-color: #f1f1f1;">
		<div
			style="display: none; font-size: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif;">
			&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;
		</div>
		<div style="max-width: 600px; margin: 0 auto;" class="email-container">
			<!-- BEGIN BODY -->
			<table align="center" role="presentation" cellspacing="0"
				cellpadding="0" border="0" width="100%" style="margin: auto;">
				<tr>
					<td valign="top" class="bg_white"
						style="padding: 1em 2.5em 0 2.5em;">
						<table role="presentation" border="0" cellpadding="0"
							cellspacing="0" width="100%">
							<tr>
								<td class="logo" style="text-align: center;">
									<h1>Welcome</h1>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<!-- end tr -->
				<tr>
					<td valign="middle" class="hero bg_white"
						style="padding: 2em 0 4em 0;">
						<table>
							<tr>
								<td>
									<div class="text" style="padding: 0 2.5em; text-align: center;">
										<h2>Finish creating your account.</h2>
										<h3>
											Hi
											<p th:text="${firstName}">
										</h3>
										<h3>We're excited to have you get started. First, you
											need to confirm your account. Just press the button below.</h3>
										<p>
											<a th:href="${verificationURL}" class="btn btn-primary">Validate
												Account</a>
										</p>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text" style="padding: 0 2.5em; text-align: center;">
										<h3>if you experience any issues with the button above,
											copy and paste the URL below into your web browser.</h3>
										<p th:text="${verificationURL}"></p>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<!-- end tr -->
				<!-- 1 Column Text + Button : END -->
			</table>
			<table align="center" role="presentation" cellspacing="0"
				cellpadding="0" border="0" width="100%" style="margin: auto;">
				<tr>
					<td valign="middle" class="bg_light footer email-section">
						<table>
							<tr>
								<td valign="top" width="33.333%" style="padding-top: 20px;">
									<table role="presentation" cellspacing="0" cellpadding="0"
										border="0" width="100%">
										<tr>
											<td style="text-align: left; padding-right: 10px;">
												<h3 class="heading">About</h3>
												<p>Welcome to Java Development Journal Blog. We publish
													articles on Spring, Spring Boot and Spring Security.</p>
											</td>
										</tr>
									</table>
								</td>
								<td valign="top" width="33.333%" style="padding-top: 20px;">
									<table role="presentation" cellspacing="0" cellpadding="0"
										border="0" width="100%">
										<tr>
											<td
												style="text-align: left; padding-left: 5px; padding-right: 5px;">
												<h3 class="heading">Contact Info</h3>
												<ul>
													<li><span class="text">Java Development Journal</span></li>
												</ul>
											</td>
										</tr>
									</table>
								</td>
								<td valign="top" width="33.333%" style="padding-top: 20px;">
									<table role="presentation" cellspacing="0" cellpadding="0"
										border="0" width="100%">
										<tr>
											<td style="text-align: left; padding-left: 10px;">
												<h3 class="heading">Useful Links</h3>
												<ul>
													<li><a href="#">Home</a></li>
													<li><a href="#">About</a></li>
												</ul>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<!-- end: tr -->
			</table>

		</div>
	</center>
</body>
</html>
```
#Create context/AccountVerificationEmailContext.java

```java
package com.SpringSecurityApp.context;

import org.springframework.web.util.UriComponentsBuilder;

import com.SpringSecurityApp.entity.UserEntity;

public class AccountVerificationEmailContext extends AbstractEmailContext {

	private String token;

	@Override
	public <T> void init(T context) {
		// we can do any common configuration setup here
		// like setting up some base URL and context
		UserEntity customer = (UserEntity) context; // we pass the customer informati
		put("firstName", customer.getFirstName());
		setTemplateLocation("emails/email-verification");
		setSubject("Complete your registration");
		//setFrom("mainulhasan3787@gmail.com");
		setFrom("testtune4@gmail.com");
		setTo(customer.getEmail());
	}

	public void setToken(String token) {
		this.token = token;
		put("token", token);
	}

	public void buildVerificationUrl(final String baseURL, final String token) {
		final String url = UriComponentsBuilder.fromHttpUrl(baseURL).path("/register/verify").queryParam("token", token)
				.toUriString();
		put("verificationURL", url);
	}

}
```
# Updatate RegistrationController
```java

	@GetMapping("/verify")
	public String verifyCustomer(@RequestParam(required = false) String token, final Model model,
			RedirectAttributes redirAttr) {
		if (StringUtils.isEmpty(token)) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.missing.token", null, LocaleContextHolder.getLocale()));
			return REDIRECT_LOGIN;
		}
		try {
			userService.verifyUser(token);
		} catch (InvalidTokenException e) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.invalid.token", null, LocaleContextHolder.getLocale()));
			return REDIRECT_LOGIN;
		}

		redirAttr.addFlashAttribute("verifiedAccountMsg", messageSource
				.getMessage("user.registration.verification.success", null, LocaleContextHolder.getLocale()));
		return REDIRECT_LOGIN;
	}
```
# Complete Code for RegistrationController
```java
package com.SpringSecurityApp.controller.user;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.service.UserService;


@Controller
@RequestMapping("/register")
public class RegistrationController {

	private static final String REDIRECT_LOGIN = "redirect:/login";

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public String register(final Model model) {
		model.addAttribute("userData", new UserData());
		return "account/register";
	}

	@PostMapping
	public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult,
			final Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("registrationForm", userData);
			return "account/register";
		}
		try {
			userService.register(userData);
		} catch (UserAlreadyExistException e) {
			bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
			model.addAttribute("registrationForm", userData);
			return "account/register";
		}
		model.addAttribute("registrationMsg", messageSource.getMessage("user.registration.verification.email.msg", null,
				LocaleContextHolder.getLocale()));
		return "account/register";
	}

	@GetMapping("/verify")
	public String verifyCustomer(@RequestParam(required = false) String token, final Model model,
			RedirectAttributes redirAttr) {
		if (StringUtils.isEmpty(token)) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.missing.token", null, LocaleContextHolder.getLocale()));
			return REDIRECT_LOGIN;
		}
		try {
			userService.verifyUser(token);
		} catch (InvalidTokenException e) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.invalid.token", null, LocaleContextHolder.getLocale()));
			return REDIRECT_LOGIN;
		}

		redirAttr.addFlashAttribute("verifiedAccountMsg", messageSource
				.getMessage("user.registration.verification.success", null, LocaleContextHolder.getLocale()));
		return REDIRECT_LOGIN;
	}

}
```
# Add Method in DefaultUserService method name verifyUser
```java
@Override
	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}
		UserEntity user = userRepository.getOne(secureToken.getUser().getId());
		if (Objects.isNull(user)) {
			return false;
		}
		user.setAccountVerified(true);
		userRepository.save(user); // let’s same user details

		// we don’t need invalid password now
		secureTokenService.removeToken(secureToken);
		return true;
	}
```
# Update Application.properties
```properties

#disabling cache for the development purpose
spring.template.cache=false
spring.thymeleaf.cache=false

#secure token configuration
# 60 * 60 * 8 // setting as 8 hours,

jdj.secure.token.validity = 28800
site.base.url.http=http://localhost:8080
site.base.url.https=http://localhost:8080



########## SMTP configuration to send out emails ##########
####### Make sure to use the correct SMTP configurations #######
spring.mail.host=smtp.gmail.com
spring.mail.username= youremail
spring.mail.password= emailpassword
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.socketFactory.port=465
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.smtp.socketFactory.fallback=false
mail.smtp.starttls.enable=true

spring.jpa.hibernate.ddl-auto = update
#spring.jpa.hibernate.ddl-auto= create-drop

```
# DefaultUserService
```java
package com.SpringSecurityApp.service.impl;

import java.util.Objects;

import javax.mail.MessagingException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.context.AccountVerificationEmailContext;
import com.SpringSecurityApp.core.exception.InvalidTokenException;
import com.SpringSecurityApp.core.exception.UnkownIdentifierException;
import com.SpringSecurityApp.core.exception.UserAlreadyExistException;
import com.SpringSecurityApp.data.user.UserData;
import com.SpringSecurityApp.entity.UserEntity;
import com.SpringSecurityApp.repository.SecureTokenRepository;
import com.SpringSecurityApp.repository.UserRepository;
import com.SpringSecurityApp.security.jpa.SecureToken;
import com.SpringSecurityApp.service.EmailService;
import com.SpringSecurityApp.service.SecureTokenService;
import com.SpringSecurityApp.service.UserService;

@Service("userService")

public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SecureTokenService secureTokenService;

	@Autowired
	SecureTokenRepository secureTokenRepository;

	@Value("${site.base.url.https}")
	private String baseURL;

	@Override
	public void register(UserData user) throws UserAlreadyExistException {
		if (checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(user, userEntity);
		userRepository.save(userEntity);
		sendRegistrationConfirmationEmail(userEntity);

	}

	@Override
	public void sendRegistrationConfirmationEmail(UserEntity user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken);
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private void encodePassword(UserData source, UserEntity target) {
		target.setPassword(passwordEncoder.encode(source.getPassword()));
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	@Override
	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}
		UserEntity user = userRepository.getOne(secureToken.getUser().getId());
		if (Objects.isNull(user)) {
			return false;
		}
		user.setAccountVerified(true);
		userRepository.save(user); // let’s same user details

		// we don’t need invalid password now
		secureTokenService.removeToken(secureToken);
		return true;
	}

	@Override
	public UserEntity getUserById(String id) throws UnkownIdentifierException {
		UserEntity user = userRepository.findByEmail(id);
		if (user == null || BooleanUtils.isFalse(user.isAccountVerified())) {
			// we will ignore in case account is not verified or account does not exists
			throw new UnkownIdentifierException("unable to find account or account is not active");
		}
		return user;
	}

}
```
# Logout Functionality
# Enable this part from userProfile.html
```html
<form name="logoutForm" th:action="@{/logout}" method="post"
							th:hidden="true">
							<input hidden type="submit" value="Sign Out" />
						</form>
```
# Complete Code for userProfile is
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
		<li class="nav-item d-none d-sm-inline-block"><a
			href="index.html" class="nav-link">Home</a></li>
		<li class="nav-item d-none d-sm-inline-block"><a href="#"
			class="nav-link">Contact</a></li>

	</ul>

	<ul class="navbar-nav ml-auto">
		<li class="dropdown user user-menu"
			sec:authorize="hasAuthority('USER')"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				<span class="hidden-xs" sec:authentication="name"></span>
		</a>
			<ul class="dropdown-menu">
				<li class="user-header"><img th:src="@{/dist/img/avatar5.png}"
					class="img-circle" alt="User Image">

					<p>
						Spring Security App <small>Java Development Application</small>
					</p></li>

				<div sec:authorize="isAuthenticated()"></div>
				<li class="user-footer">
					<div class="pull-right">
						<a href="javascript: document.logoutForm.submit()"
							class="btn btn-default btn-flat">Sign out</a>
						<form name="logoutForm" th:action="@{/logout}" method="post"
							th:hidden="true">
							<input hidden type="submit" value="Sign Out" />
						</form>
					</div>
					</li>
				</li>
			</ul>
</nav>
```