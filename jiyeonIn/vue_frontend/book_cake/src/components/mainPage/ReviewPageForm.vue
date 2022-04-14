<template class="reviewForm">
    <div>
        <form @submit.prevent="onSubmit" >
            <div v-if="checkuserInfo != null" class="showInputReview">
                <p>아이디 : {{id}}</p>
                <textarea type="text" v-model="content" placeholder="후기를 입력해주세요!" class="inputReview"/><br>
                <input type="file" id="files1" ref="files1"
                    multiple v-on:change="handleFileUpload()"/>
                <v-btn class="registerReview" type="submit" color="white">
                    <p>등록하기</p>
                </v-btn>
                <br><br><br><hr>
            </div>
        </form>

            <v-layout row wrap>
                <v-flex xs12>
                    <v-data-table :headers="headerTitle" :items="reviews" class="elevation-0">
                        <template v-slot:[`item.reviewFile`]="{ item }">
                            <img v-bind:src="require(`@/assets/review/${item.reviewFile}`)" height="250px"/>
                        </template>

                        
                            
                    </v-data-table>
                </v-flex>
            </v-layout>

            <v-dialog
                v-model="dialog"
                width="500"
                >
                <template v-slot:activator="{ on, attrs }">
                    <v-btn
                    color="red lighten-2"
                    dark
                    v-bind="attrs"
                    v-on="on"
                    >
                    Click Me
                    </v-btn>
                </template>

                <v-card>
                    <v-card-title class="text-h5 grey lighten-2">
                    Privacy Policy
                    </v-card-title>

                    <v-card-text>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </v-card-text>

                    <v-divider></v-divider>

                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        color="primary"
                        text
                        @click="dialog = false"
                    >
                        I accept
                    </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
            

</div>
</template>

<script>
    export default {
        name:'ReviewPageForm',
        data() {
            return {
                checkuserInfo: window.localStorage.getItem('token'),
                id: (window.localStorage.getItem('id')),
                content:'',
                headerTitle: [
                { text:'no', value: 'reviewNo', width:'70px'},
                { text:'reviewFile', value: 'reviewFile', width:'70px'},
                { text: 'content', value: 'content', width: "300px" },
                { text: 'writer', value: 'id', width: "150px" },
                { text: 'date', value: 'regDate', width: "200px" },
                ],
            }
        },
        props: {
            reviews: {
                type: Array,
                required: true
            }
        },
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit() {
                const {id, content, files1} = this
                this.$emit('submit', {id, content, files1})
            }
        }
        
    }    
</script>

<style scoped>
.showInputReview{
    margin-bottom: 30px;
}
.inputReview {
    border: 2px solid rgb(37, 26, 26);
    width:700px;
    height: 100px;
    color:black;
}

.reviewForm {
    padding: 0 0 0 10%;
}

.registerReview{
    margin-left: 30%;
    margin-top: 5px;
}
.showReview {
    width: 800px;
    margin-top: 5px;
    padding: 0 0 0 2%;
}

img .fixed{
    position: static;
    height:250px; 
    width:250px
}

.showDetail {
    top: 0px;
    left: 100px;
}

</style>