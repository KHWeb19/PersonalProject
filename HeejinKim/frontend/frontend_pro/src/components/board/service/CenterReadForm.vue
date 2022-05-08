<template>
    <v-container>
        <table>
            <v-row justify="center">
                <v-col cols="1" class="label">Title</v-col>
                <v-col>
                    <v-text-field rounded style="width:300px" readonly :value="center.title"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="1" class="label"> Writer</v-col>
                <v-col>
                    <v-text-field rounded style="width:150px" readonly :value="center.writer"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="1" class="label"> Date</v-col>
                <v-col>
                    <v-text-field class="date" rounded readonly :value="center.updDate"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="12">
                    <v-textarea cols="80" rows="20" outlined color="grey"
                    style="white-space:pre-line"  class="mt-3" readonly
                    :value="center.content">
                    </v-textarea>
                </v-col>
            </v-row>

            <v-row justify="center">
                <img v-if="this.center.fileName !== null && this.center.fileName !== 'null'" class="addImg" 
                :src="require(`@/assets/uploadImg/${this.center.fileName}`)">
            </v-row>
            
            <v-row>
                <v-btn @click="backPage" class="backBtn" dark> Back</v-btn>
            </v-row>

            <v-row v-if="center.writer == this.userId">  
    
                <router-link :to="{name:'CenterModify', params:{centerNo: center.centerNo.toString()}}" style="text-decoration:none">
                    <v-btn class="modifyBtn">Modify</v-btn>
                </router-link>
        
                <v-btn @click=onDelete dark>Delete</v-btn>

            </v-row>

        </table>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'
export default {
    name:'CenterReadForm',
    
    props: {
        center: {
            type: Object,
            required: true
        }
    },

    data () {
        return {

        fileName: this.center.fileName,
        

        }
    },
    created () {
        this.centerNo = this.center.centerNo
        this.userId = this.$store.state.session.userId
    },
    methods: {
        ...mapActions(['fetchCenterList','fetchCenterCommentsList']),
        backPage () {
            this.$router.push('/serviceBoard')
        },
        onDelete () {
            const { centerNo, fileName } = this.center
            
            axios.delete(`http://localhost:7777/board/center/${centerNo}`, {fileName})
                    .then(() => {
                        alert('게시글 삭제')
                        this.$router.push({ name: 'CenterList' })
                    })
                    .catch(() => {
                        alert('삭제 실패')
                    })
        },
    }
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");
.label{
    font-family: 'Ubuntu', sans-serif; 
    font-size: 17pt;
    margin-right:5%;
    text-align: center;
    padding-top: 25px; 
}
table{
    background-color: #f3f3f3;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
}
.modifyBtn{
    color:rgba(214, 86, 103, 0.596);  
}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.addImg {
    position: relative;
    max-height: 400px;
    max-width: 500px;
}
</style>
    