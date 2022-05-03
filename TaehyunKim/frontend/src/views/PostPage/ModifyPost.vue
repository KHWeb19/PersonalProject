<template>
    <v-container>
        <div class="main-div" v-if="post">
            <p>{{post.title}}</p>
        </div>
        
        <div class="btn-container">
            <button class="btn-container__buttons" @click="btnBold"><font-awesome-icon icon="fa-solid fa-bold"/></button>
            <button class="btn-container__buttons" @click="btnUnderline"><font-awesome-icon icon="fa-solid fa-underline" /></button>
            <button class="btn-container__buttons" @click="btnItalic"><font-awesome-icon icon="fa-solid fa-italic" /></button>
            <button class="btn-container__buttons" @click="btnStrike"><font-awesome-icon icon="fa-solid fa-strikethrough" /></button>
            <button class="btn-container__buttons" @click="inputImgClicked"><font-awesome-icon icon="fa-solid fa-image" /></button>
        </div>

        <v-row justify="center">
            <v-col cols="12">
                <div contenteditable="true" id="the-content" @input="contentChanged" class="section-one section-one__editor">
                </div>
            </v-col>
        </v-row>

        <input id="inputImg" type="file" multiple ref="files" accept="image/*" style="display: none">
        <div class="section-one section-one__div-flex">
            <v-btn class="primary" @click="modifyPost()">Update Post</v-btn>
        </div>
    </v-container>
</template>

<script>
import axios from "axios"
import {mapActions, mapState} from 'vuex'
import {PostUtility} from '@/javascript/postutility'
import {v4 as uuidv4} from 'uuid'

export default{

    data(){
        return {
            content: '',
            files: [],
            previews: [],
            strUUID: ''
        }
    },

    
    computed:{
        ...mapState(['post'])
    },

    watch:{
        content:{
            handler(newVal, oldVal){
                if (newVal.length <= oldVal.length){
                    this.checkPreviewDeleted()
                }
            }
        }
    },
    methods:{
        ...mapActions(['read_post']),
         contentChanged(e){
            this.content = e.target.innerHTML
        },
        checkPreviewDeleted(){
            this.previews.forEach(item => {
                if(!this.content.includes(item)){
                    this.previews.splice(this.previews.indexOf(item))
                }
            })
        },
        inputImgClicked(){
            const inputImg = document.getElementById("inputImg")
            inputImg.click() 
        },

        btnBold(){
            document.execCommand('bold')
        },
        btnUnderline(){
            document.execCommand('underline')
        },
        btnItalic(){
            document.execCommand('italic')
        },
        btnStrike(){
            document.execCommand('strikeThrough')
        },

        replaceImgTags(){
            this.strUUID = uuidv4()
            this.previews.forEach(() => {
                let startIdx = this.content.indexOf("<img src=\"")
                let endIdx = this.content.indexOf("\">")
                let strToReplace = this.content.substring(startIdx, endIdx+2)
                this.content = this.content.replace(strToReplace, this.strUUID)
            })
        },

        modifyPost(){
            let formData = new FormData()

            this.files.forEach((file) => formData.append('fileList', file))
            this.replaceImgTags()

            this.post.content = this.content

            formData.append("post", new Blob([JSON.stringify(this.post)], {type: "application/json"}))
            formData.append("strUUID", this.strUUID)

            axios.post(`freepost/modify/${this.$route.params.no}`, formData)
            .then(() => this.$router.push("/readpost/" + this.$route.params.no))
            .catch(() => console.log("Unable to modify post"))

        }
 
    },

    created(){
        this.read_post(this.$route.params.no)
    },

    mounted(){
            document.getElementById("inputImg").addEventListener('change',
            (e) => {
                let files = e.target.files
                let promises = []
                if (!files.length) return

                for (let i=0; i<files.length; i++){
                    this.files.push(files[i])
                    promises.push(PostUtility.readFile(files[i]))
                }

                Promise.all(promises).then((values) => {
                    values.forEach((item) => {
                        document.getElementById('the-content').focus({preventScroll: true})

                        //let imgWithTag = "<img src=\"" + item + "\">"
                        //document.execCommand('insertHTML', false, imgWithTag)
                        document.execCommand('insertImage', false, item)

                        this.previews.push(item)})
                    })
                })
    },

    beforeUpdate(){
        var htmlObj = document.getElementById("the-content")
        htmlObj.innerHTML = this.post.content
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

<style src="../../assets/css/create.css" scoped>
</style>