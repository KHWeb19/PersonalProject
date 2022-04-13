<template>
    <log-in-component @submitted="sending"></log-in-component>
</template>

<script>
import LogInComponent from '../components/LogInComponent.vue'
import axios from "axios"

export default{
    components: {
        LogInComponent
    },
    methods:{

        sending(params){
            axios.post("http://localhost:1234/api/login", params)
            .then(
                (res) => {
                    let config = {
                        headers: {
                            "Authorization": "Bearer " + res.data.access_token
                        }
                    }
                    axios.get("http://localhost:1234/api/users", config)
                    .then((result) => console.log(result.data))
                    .catch((e) => alert("로딩 실패 "+e))
                }
            )
            .catch((e)=> alert("실패" + e))
        }
    }
}
</script>