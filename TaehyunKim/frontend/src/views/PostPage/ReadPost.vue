<template>
    <v-container>
        <div class="div-top" v-if="post">
            <div class="div-top div-top__flex_between">
                <span class="div-top__title">{{post.title}}</span>
                <span>{{post.regdate}}</span>
            </div>
            <hr>
            <div class="div-top div-top__flex_between">
                <span>Author: {{post.author}}</span>
                <span>Views: {{post.hits}}</span>
            </div>
            <hr>
        </div>
        <div id="the-content"></div>
        <div class="d-flex justify-end my-2">
            <v-btn color="primary" class="mx-1" :to="{name: 'modifypost', params: $route.params.no}">Modify</v-btn>
            <v-btn color="red white--text" @click="deletePost">Delete</v-btn>
        </div>
        <comments-create />
        <hr>
        <read-comments :comments = "comments" />
        <the-pagination :posts= "comments" />
    </v-container>
</template>

<script>
import axios from 'axios'
import {mapActions, mapState} from 'vuex'
import {TimeConverter} from '../../javascript/timeconverter'
import CommentsCreate from '../../components/comments/CommentsCreate.vue'
import ReadComments from '../../components/comments/ReadComments.vue'
import ThePagination from '../../components/ThePagination.vue'

    export default{
        data(){
            return{
                firstLoad: true
            }
        },
        components:{
            CommentsCreate,
            ReadComments,
            ThePagination
        },
        computed:{
            ...mapState(['post', 'comments'])
        },
        methods:{
            ...mapActions(['read_post', 'list_comments']),
            appendContent(){
                var htmlObject = document.createElement('div')
                htmlObject.innerHTML = this.post.content
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
                            this.$router.push({name: "home"})
                            })
                        .catch(() => alert("Unable to delete post"))
                    }  
                    else{
                        alert("Only the author can delete the post")
                    }
                })
                .catch((err) => alert(err))
            },
            readComments(){
                this.list_comments({params: {no: this.$route.params.no}})
                .then((res) => this.comments = res.data)
                .catch(() => "Failed to load comments")
            }
        },

        created(){
            this.read_post(this.$route.params.no)
        },
        beforeUpdate(){
            if (this.firstLoad){
                this.appendContent()
                this.firstLoad = false
                TimeConverter.removeMicrosecond(this.post)
            }
        }
    }
</script>

<style scoped>
    #the-content{
        margin: 20px 0 10px 0;
        padding: 10px;
        box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    }

    .div-top{
    margin: 4px;
    padding: 4px;
    }

    .div-top__flex_between
    {
        display: flex;
        justify-content: space-between;
    }
    .div-top__title{
    font-size: 30px;
    font-weight: bold;
    }

   
    #the-content{
        min-height: 500px;
    }

</style>