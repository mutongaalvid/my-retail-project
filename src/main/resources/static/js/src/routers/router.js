import Vue from "vue"

import Router from "vue-router";

const Login = () => import("../components/About")



Vue.use(Router);

const routes = [
    {
    path: "/login",
    component: Login
    }
]

const router = new Router({
    mode: "history",
    routes: routes
})

export default router;