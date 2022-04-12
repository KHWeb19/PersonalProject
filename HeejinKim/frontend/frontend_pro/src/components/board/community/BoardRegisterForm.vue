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
                    <v-btn @click="cancel" class="cancleBtn" color="grey" dark>cancle</v-btn>
                    <v-btn type="submit" class="writeBtn" color="black" dark>submit</v-btn>
                </v-row>
            </table>
        </v-form>
    </v-container>
</template>

<script>
export default {
    name:'CommunityBoardWirte',
    data() {
        return {

            title:'',
            content:'',
            //files: '',
            image :''
            
        }
    },
    mounted () {
        this.writer = this.$store.state.session.userId
    },
    methods: {
        handleFileUpload () {

            console.log('add Image')

            this.files = this.$refs.files.files
            this.image = URL.createObjectURL(this.files[0])
             
            
        },
        onSubmit () {
            const { title, content,writer } = this
            this.$emit('submit', { title, content,writer })
            console.log(title,content,writer)
        },
        cancel (){
            this.$router.push('/communityBoard')
        },
        
        fileDeleteButton () {
            this.files = '',
            this.image = ''
        },       
    }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');



.label{

    font-size: 17pt;
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
   

.cancleBtn {
    position: relative;
    margin-top:1%;   
}
.writeBtn {
     margin-top:1%;      
}
.imageDeleteBtn{

    zoom:0.8;
    margin-left:3%;
    
}

</style>