<template>
    <div class="reviewForm">
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
        
        <v-container v-for="(review, index) in reviews" :key="index">
            <v-row>
                <v-col  class="col-12 col-sm-4">
                    <div v-if="review.reviewFile != null">
                        <v-img v-bind:src="require(`@/assets/review/${review.reviewFile}`)" contain class="fixed" style="height:250px; width:250px" />
                    </div>
                    <div v-if="review.reviewFile == null">
                        <v-img src="@/assets/review/nullImg.png" contain class="fixed" style="height:250px; width:250px" />
                    </div>
                </v-col>
                <v-col  class="col-12 col-sm-6">
                    <div class="showDetail">
                        <strong>{{review.id}}</strong>
                        <p></p><p></p>
                        <p>{{review.content}}</p>
                        <p style="text-align: left;">{{review.regDate}}</p>
                    </div>
                </v-col>
            </v-row>
            <hr>
        </v-container>




        <div v-for="(review, index) in reviews" :key="index" class="showReview">
            <br><hr><br>
            <div v-if="review.reviewFile != null">
                <v-img v-bind:src="require(`@/assets/review/${review.reviewFile}`)" contain class="fixed" style="height:250px; width:250px" />
            </div>
            <div v-if="review.reviewFile == null">
                <v-img src="@/assets/review/nullImg.png" contain class="fixed" style="height:250px; width:250px" />
            </div>
            <div class="showDetail">
                <strong>{{review.id}}</strong>
                <p>{{review.content}}</p>
                <p>{{review.regDate}}</p>
            </div>
        </div>


        <v-container>
        <v-row justify="center">
            <v-data-table 
                        :headers="headerTitle" 
                        :items="reviews"
                        :key="reviews.reviewNo"
                        :items-per-page="10"
                        class="elevation-1"
                        style="background: green-light;" 
                        >
<!--                         
            시도 1 
            <template v-slot:[`item.reviewFile`]="{ item }">
                <div class="p-2">
                    <v-img :src="require(`@/assets/bookingImg/${item.reviewFile}`)" :alt="item.content" height="100px"></v-img>
                </div>
            </template> -->
            
            시도 2 
                <template slot="items" slot-scope="props">
                    <td class="text-xs-right">{{ props.item.reviewNo }}</td>
                    <td><img :src="require(`@/assets/bookingImg/${item.reviewFile}`)" style="width: 50px; height: 50px"></td>
                    <td class="text-xs-right">{{ props.item.content }}</td>
                    <td class="text-xs-right">{{ props.item.id }}</td>
                    <td class="text-xs-right">{{ props.item.regDate }}</td>
                </template>       
            </v-data-table>
        </v-row>
        
        </v-container>


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
                { text:'image', value: 'reviewFile', width:'70px'},
                { text: 'content', value: 'content', width: "300px" },
                { text: 'writer', value: 'id', width: "150px" },
                { text: 'date. ', value: 'regDate', width: "200px" },
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