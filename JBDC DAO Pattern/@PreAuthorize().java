In Spring Security, @PreAuthorize is a method level annotation that is used to restrict access to a method based on the user's role and/or authorities.

hasRole and hasAuthority are two methods available in @PreAuthorize that can be used to check if the user has a certain role or authority before allowing access to the method.

hasRole method is used to check if the user has a specific role. It takes a string parameter which represents the role. For example,
if you want to allow only users with the role "ADMIN" to access a method, you can use the following code:


@PreAuthorize("hasRole('ADMIN')")
public void adminMethod() {
    // code here
}
hasAuthority method is used to check if the user has a specific authority. It also takes a string parameter which represents the authority. 
For example, if you want to allow only users with the authority "READ_DATA" to access a method, you can use the following code:

@PreAuthorize("hasAuthority('READ_DATA')")
public void readDataMethod() {
    // code here
}

It's important to note that the hasRole method automatically prefixes the role with "ROLE_" before checking, so it's the same as using hasAuthority("ROLE_ADMIN")

You can also use logical operators like and, or, not to combine multiple expressions.

It's also possible to use @Secured annotation which is similar to @PreAuthorize but it supports only role based authorization,
whereas @PreAuthorize supports both role and authority based authorization.
