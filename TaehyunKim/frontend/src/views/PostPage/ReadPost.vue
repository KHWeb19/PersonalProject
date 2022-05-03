<template>
    <v-container>
        <div v-if="post">
            <p>{{post.id}}</p>
            <p>{{post.title}}</p>
            <p>{{post.author}}</p>
            <hr>
        </div>
        <div id="the-content"></div>
        <hr>
        <div class="d-flex justify-end my-2">
            <span>{{this.$route.params.no}}</span>
            <v-btn color="primary" class="mx-1" :to="{name: 'modifypost', params: $route.params.no}">Modify</v-btn>
            <v-btn color="red white--text" @click="deletePost">Delete</v-btn>
        </div>
        <hr>
    </v-container>
</template>

<script>
import axios from 'axios'
import {mapActions, mapState} from 'vuex'

    export default{
    
        computed:{
            ...mapState(['post'])
        },
        methods:{
            ...mapActions(['read_post']),
            appendContent(){
                var htmlObject = document.createElement('div')
                htmlObject.innerHTML = this.post.content
                htmlObject.classList.add('editor')
                var element = document.getElementById("the-content")
                element.appendChild(htmlObject)
                
            },
            deletePost(){
                axios.get(`/freepost/validate/${this.$route.params.no}`)
                .then((res) => {
                    if (res.data){
                        axios.delete(`/freepost/delete/${this.$route.params.no}`)
                        .then(() => {
                            alert("Post successfully deleted")
                            this.$router.push("/")
                            })
                        .catch(() => alert("Unable to delete post"))
                    }  
                    else{
                        alert("Only the author can delete the post")
                    }
                })
                .catch((err) => alert(err))
            }
        },
        created(){
            this.read_post(this.$route.params.no)
        },
        beforeUpdate(){
            this.appendContent()
        }
    }
</script>

<style scoped>
    #the-content{
        margin: 20px 0 10px 0;
        padding: 10px;
        box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    }
    .editor img {
        width: 100px;
        height: 100px;
    }
</style>