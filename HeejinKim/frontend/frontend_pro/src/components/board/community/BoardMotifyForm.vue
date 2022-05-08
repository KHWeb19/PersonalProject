<template>
    <v-container>
            <v-form @submit.prevent="onSubmit">
                <table>
                    <v-row justify="center">
                        <v-col cols="1" class="label mt-5 ml-4" >Title</v-col>
                        <v-col>
                            <v-text-field  type="text" v-model="title"/>
                        </v-col>
                    </v-row>

                    <v-row>
                        <v-col cols="12">
                            <v-textarea cols="80" rows="20" outlined color="grey"
                            style="white-space:pre-line" placeholder="content" class="mt-3"
                            v-model="content">
                            </v-textarea>
                        </v-col>
                    </v-row>

                    <v-row  wrap justify="center">

                        <v-col cols="1" class="label" > Images </v-col>

                        <v-col>
                            <input type="file" id="files" ref="files" style="width:150px" clearable 
                                multiple="multiple" v-on:change="handleFileUpload()"/>
                            <v-btn @click="fileDeleteButton()" class="imageDeleteBtn">delete Image</v-btn>
                        </v-col>

                        <v-col cols="12">
                        <v-img :src="image" alt=""/>
                        </v-col>
                    </v-row>


                     <v-row wrap>
                            <router-link :to="{ name: 'BoardRead',
                                params: { boardNo: board.boardNo.toString() } }" style=" text-decoration:none"><v-btn color="grey" dark >cancle</v-btn></router-link>
                        <v-btn type="submit" color="black" dark>Modify</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>
export default {

    name:'BoardModifyForm',

    props: {
        board: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: '',
            image :'',               
        }
    },
    methods: {
        handleFileUpload () {
           console.log('add Image')

            var image = this.$refs['files'].files[0]

            const url = URL.createObjectURL(image)
            this.image = url

            this.files = this.$refs.files.files[0]
        },

        onSubmit () {
            const { title, content, writer, fileName } = this
            const file =  this.$refs.files.files[0]

            this.$emit('submit', { title, content, writer, file,fileName })
        },
    },
    created () {
        this.writer = this.board.writer
        this.title = this.board.title
        this.content = this.board.content
        this.fileName = this.board.fileName
        
    },
     fileDeleteButton () {
            this.files = '',
            this.image = ''
        },       

}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');

.label{

    font-size: 20pt;
    margin-right:5%;
    text-align: center;
    font-family: 'Poiret One', cursive;
}
table{ 

    background-color: #f3f3f3;;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
      
}
.imageDeleteBtn{

    zoom:0.8;
    margin-left:3%;
    
}
   
.v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}

</style>