import React, { Component } from 'react';
import { Formik } from 'formik';
import { Input, Button } from 'antd'

const inputBottomMargin = {marginBottom: '5px'};

class AddStudentForm extends Component {
    render () {
        return (
                <Formik
                initialValues={{ firstName: '', password: '' }}
                validate={values => {
                    const errors = {};
                    if (!values.firstName) {
                    errors.firstName = 'Required';
                    } else if (
                    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.firstName)
                    ) {
                    errors.firstName = 'Invalid email address';
                    }
                    return errors;
                    }}
                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                    alert(JSON.stringify(values, null, 2));
                    setSubmitting(false);
                    }, 400);
                    }}
                >
                {({
                    values,
                    errors,
                    touched,
                    handleChange,
                    handleBlur,
                    handleSubmit,
                    isSubmitting,
                    /* and other goodies */
                }) => (
                    <form onSubmit={handleSubmit}>
                    <Input
                        style={inputBottomMargin}
                        name="firstName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.firstName}
                        placeholder='First Name. E.g Adiya'
                    />
                    {errors.firstName && touched.firstName && errors.firstName}
                    <Input
                        style={inputBottomMargin}
                        name="lastName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.lastName}
                        placeholder='Last Name. E.g Bahuguna'
                    />
                    {errors.lastName && touched.lastName && errors.lastName}
                    <Input
                        style={inputBottomMargin}
                        name="email"
                        type='email'
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.email}
                        placeholder='email. E.g @gmail.com'
                    />
                    {errors.email && touched.email && errors.email}
                    <Input
                        style={inputBottomMargin}
                        name="gender"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.gender}
                        placeholder='Gender. E.g Male or Female'
                    />
                    {errors.gender && touched.gender && errors.gender}
                    <Button type="submit" disabled={isSubmitting}>
                        Submit
                    </Button>
                    </form>
                )}
                </Formik>
        );
    }
}

export default AddStudentForm;