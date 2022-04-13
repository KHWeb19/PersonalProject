<template>
    <div>
        <form>
            <label>Create an account</label>
            <br><br>
            First name <input type="text" v-model="first_name" placeholder="First name">
            <br>
            Last name <input type="text" v-model="last_name" placeholder="Last name">
            <br>
            Email <input type="text" v-model="email" placeholder="email">
            <br>
            Username <input type="text" v-model="username" placeholder="username">
            <br>
            Password <input type="text" v-model="password" placeholder="password">
            <br>
            Password Confirm <input type="text" v-model="passwordconfirm" placeholder="passwordconfirm">
        </form>
        <button @click="submitted">Register</button>
    </div>
</template>

<script>
export default{
    data() {
        return {
            first_name: '',
            last_name: '',
            email: '',
            username: '',
            password: '',
            passwordconfirm: ''
        }
    },
    methods:{
        submitted(){
            const {first_name, last_name, email, username, password} = this
            const payload = {first_name, last_name, email, username, password}
            this.$emit("submitted", payload)
            }
    }
}
</script>