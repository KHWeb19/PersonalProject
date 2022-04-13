<template>
    <div>
        Username: <input type="text" v-model="username"><br>
        Password: <input type="text" v-model="password"><br>

        <button @click="submitted">Submit</button>
    </div>
</template>

<script>
export default{
    data(){
        return {
        username: '',
        password: '',
        }
    },
    methods:{
        submitted(){
            const params = new URLSearchParams();
            params.append('username', this.username)
            params.append('password', this.password)
            this.$emit("submitted",params)
        }
    }
}
</script>
