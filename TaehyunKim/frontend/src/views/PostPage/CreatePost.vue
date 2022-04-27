<template>
    <v-container>
        <table>
            <tr>
                <td>Title: <input type="text" v-model="title"></td>
            </tr>
            <tr>
                <td> Content: <input type="text" v-model="content"></td>
            </tr>
        </table>

        
        <input type="file" @change="addFiles" multiple ref="files" accept="image/*">


        <div v-for="(file, idx) in preview" :key="idx + file">
            <img :src="file" height="100" width="100">
            <v-btn @click="deletePreview(idx)">delete</v-btn>
        </div>
        
        <v-btn @click="createPost">Create</v-btn>
    </v-container>
</template>

<script>
import axios from 'axios'
import {PostUtility} from '../../javascript/postutility'

export default{
    
    data(){
        return{
            title: '',
            content: '',
            files: [],
            preview: []
        }
    },
    methods: {
        createPost(){
            let formData = new FormData()

            for (let i = 0; i<this.files.length; i++){
                formData.append('fileList', this.files[i])
            }


            const {title, content} = this
            const fileinfo = {title, content}


            formData.append("info", new Blob([JSON.stringify(fileinfo)], {type: "application/json"}))
            

            axios.post('freepost/create', formData)
            .then(
                this.$router.push("/listpost")
            )
            .catch(() =>alert("Failed Creating Post"))
        },

        addFiles: function(e){
            PostUtility.AddFile(e,this.files, this.preview)
        },
        
        deletePreview(index){
            
            this.files.splice(index, 1)
            this.preview.splice(index, 1)

            console.log(this.files)
        }
    
        
    }
}
</script>
