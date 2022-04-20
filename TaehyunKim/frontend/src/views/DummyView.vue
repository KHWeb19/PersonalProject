<template>
<div>
    <h3>hello</h3>
    <button @click="realdummy">lets go to admin page</button>
</div>
</template>

<script>
import axios from "axios"
export default{

    methods:{
        realdummy(){
            /*let config = {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("access_token")
                }
            }
            axios.get("admins", config)*/
            axios.get("admins")
            .then(console.log("dummy success"))
            .catch(console.log("dummy request failed"))

        }

    }

}
</script>
