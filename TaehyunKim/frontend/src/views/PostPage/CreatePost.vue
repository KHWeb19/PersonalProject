<template>
    <v-container class="the-container">
        <div class="section-one">
            <p class="section-one section-one__title">Create Post</p>
            <hr>
            <v-row justify="center">
                <v-col cols="12">
                    <input type="text" v-model="title" placeholder="Title" class="section-one section-one__input">
                </v-col>
            </v-row>
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
            <v-btn @click="createPost" class="section-one section-one__create-btn primary">Create</v-btn>
        </div>

             
    </v-container>
</template>

<script>
import axios from 'axios'
import {PostUtility} from '@/javascript/postutility'
import {v4 as uuidv4} from 'uuid'

export default{
    
    data(){
        return{
            title: '',
            content: '',
            files: [],
            previews: [],
            strUUID: ''
        }
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

    methods: {
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

        createPost(){
            let formData = new FormData()

            this.files.forEach((file) => formData.append('fileList', file))
            this.replaceImgTags()

            const {title, content} = this
            const fileInfo= {title, content}

            formData.append("post", new Blob([JSON.stringify(fileInfo)], {type: "application/json"}))
            formData.append("strUUID", this.strUUID)

            axios.post('freepost/create', formData)
            .then(this.$router.push("/"))
            .catch(() => alert("Failed Creating Post"))
        }
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
        }

        
}

        

</script>

<style scoped src="../../assets/css/create.css">
</style>
