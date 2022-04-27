<template>
    <v-container>
        <post-head :post="post" v-if="post"/>
        <textarea style="height: 500px" v-if="post" v-model="content">
        </textarea>
        <input type="file" @change="addfiles" multiple accept="image/*">

        <div v-for="(file, index) in originalFiles" :key="index">
                <img :src="require(`../../assets/img/${file}`)" height="100" width="100">
                <v-btn @click="deleteOriginalFile(index)">delete</v-btn>
        </div>

        <div v-for="(file, idx) in preview" :key="idx + file">
            <img :src="file" height="100" width="100">
            <v-btn @click="deletePreview">delete</v-btn>

        </div>
        <v-btn class="primary" @click="modify_post()">Modify</v-btn>
    </v-container>
</template>

<script>
import axios from "axios"
import {mapActions, mapState} from 'vuex'
import PostHead from '../../components/PostHead.vue'
import {PostUtility} from '../../javascript/postutility'

export default{

    data(){
        return {
            content: '',
            originalFiles: [],
            files: [],
            preview: []
        }
    },

    components:{
            PostHead
        },
    
    computed:{
        ...mapState(['post'])
    },
    methods:{
        ...mapActions(['read_post']),

        modify_post(){
            
            let formData = new FormData()

            for (let i =0; i<this.files.length; i++){
                formData.append('fileList', this.files[i])
            }

            this.post.content = this.content

            formData.append("post", new Blob([JSON.stringify(this.post)], {type: "application/json"}))

            axios.post(`freepost/modify/${this.$route.params.no}`, formData)
            .then(() => {
                this.$router.push("/readpost/" + this.$route.params.no)
            })
            .catch(() => console.log("modify failed!"))


        },
        readFiles(attachments){

            for (let i = 0; i< attachments.length; i++){
                   
                this.originalFiles.push(attachments[i].filename)

                }
        },
        deleteOriginalFile(index){
            this.originalFiles.splice(index, 1)
            this.post.attachments.splice(index, 1)

            console.log(this.post.attachments)
        },
        addfiles: function(e){
            PostUtility.AddFile(e,this.files, this.preview)
        },
        
        deletePreview(index){
            
            this.files.splice(index, 1)
            this.preview.splice(index, 1)

            console.log(this.files)
        }
        
    },

    created(){
        this.read_post(this.$route.params.no)
        this.content = this.post.content

        this.readFiles(this.post.attachments)
    },
    async beforeRouteEnter(to, from, next){
        const result = await axios(`freepost/validate/${to.params.no}`)
        if (result.data){
            next()
        }
        else{
            alert("Only the author can modify the post")
            next('/')
        }
    }
    

}

</script>