<%--sign up jsp--%>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container">
    <br/>

    <h2 class="h2">Sign Up</h2>
    <hr class="mb-4">

    <form class="form-horizontal" role="form" action="<c:url value="/signup"/> " method="post">

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder=""
                    value="${userDto.username}"/>

            <c:if test="${errors.username != null}">
                <small class="text-danger">${errors.username}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="you@gamil.com"
                   value="${userDto.email}"/>

            <c:if test="${errors.email != null}">
                <small class="text-danger">${errors.email}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
                   value="${userDto.password}"/>

            <c:if test="${errors.password != null}">
                <small class="text-danger">${errors.password}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="passwordConfirmed">Password Confirmed</label>
            <input type="password" class="form-control" id="passwordConfirmed" name="passwordConfirmed"
                   value="${userDto.passwordConfirmed}"/>

            <c:if test="${errors.passwordConfirmed != null}">
                <small class="text-danger">${errors.passwordConfirmed}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder=""
                   value="${userDto.firstName}"/>

            <c:if test="${errors.firstName != null}">
                <small class="text-danger">${errors.firstName}</small>
            </c:if>
        </div>


        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder=""
                   value="${userDto.lastName}"/>

            <c:if test="${errors.lastName != null}">
                <small class="text-danger">${errors.lastName}</small>
            </c:if>
        </div>

        <hr class="mb-4">

        <div class="form-group">
            <button class="btn btn-primary btn-lg" type="submit">
                SignUp
            </button>
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp"%>