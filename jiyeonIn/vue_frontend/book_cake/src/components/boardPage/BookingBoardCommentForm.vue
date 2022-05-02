<template>
    <div >
        <div class="textbox" v-for="(comment, index) in boardComments" :key="index">
            <div>
                <strong> {{ comment.id }} </strong> <br>
                <span class="comments"> 
                    {{ comment.comments}} 
                </span>
                <span> <br>
                    <v-img v-if="comment.commentLinkInfo != null" v-bind:src="require(`@/assets/boardComment/${comment.commentLinkInfo}`)" contain style="height:300px; width:300px position: fixed;" />
                </span>
                <span class="date"> <br>
                    {{ comment.regDate}} 
                    <v-btn color="black" text type="button" @click="writeComment(index)">
                        <strong>댓글쓰기</strong>
                    </v-btn>  
                </span>
                <div v-show="writeCoComent" v-if="index == checkIndex">
                    <form @submit.prevent="onSubmit">
                        <v-container>
                            <v-row >
                                <v-col>
                                    <h4>댓글 : <strong>{{id}}</strong></h4>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col class="col-12 col-sm-11">
                                    <textarea type="text" v-model="comments" placeholder="댓글을 입력해주세요" class="commentcheck" style="width: 730px;"/><br>
                                </v-col>
                                <v-col class="col-12 col-sm-1" >
                                    <v-btn class="commentRegister" type="submit" color="white">
                                        <strong>등록</strong>
                                    </v-btn>  
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <input type="file" id="files1" ref="files1" 
                                        multiple v-on:change="handleFileUpload()"/>
                                </v-col>
                            </v-row>
                        </v-container>
                        <br>
                    </form>
                </div>
                <hr>
            </div>
        </div>

        <div style="padding: 0 0 0 13%;" >
            <form @submit.prevent="onSubmit" >
                <v-container>
                    <v-row>
                        <v-col>
                            <br><br><h4>댓글 : <strong>{{this.id}}</strong></h4>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col class="col-12 col-sm-7">
                            <textarea type="text" v-model="comments" placeholder="댓글을 입력해주세요" class="commentcheck"/><br>
                        </v-col>
                        <v-col class="col-12 col-sm-1">
                            <v-btn type="submit" color="white">
                                <strong>등록</strong>
                            </v-btn>  
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col>
                            <input type="file" id="files1" ref="files1" 
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                </v-container>
            </form>
        </div>

        
        
    </div>
</template>


<script>
    export default {
        name: 'BookingBoardCommentForm',
        props: {
            boardComments: {
                type: Array,
                required: true
            },
            bookingNo: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                id: (window.localStorage.getItem('id')),
                comments: '',
                writeCoComent:false,
                writeCommentArr:[],
                writeCommentArr2:[],
                checkIndex:''
            }
        }, 
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit () {
                const { id, comments, files1 } = this
                this.$emit('submit', { id, comments, files1 })
            },
            writeComment (index) {
                this.checkIndex = index
                this.writeCoComent = true
            }
        }
    }
</script>

<style scoped>
.commentcheck {
    border: 2px solid rgb(37, 26, 26);
    width: 750px;
    height: 100px;
    color:black;
}
.textbox{
    width: 1000px;
    color:black;
    padding: 0 0 0 13%;
}

.textbox .date {
    text-align: right;
}
</style>