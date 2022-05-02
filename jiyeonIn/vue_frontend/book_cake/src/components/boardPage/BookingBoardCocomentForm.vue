<template>
    <div >
        <div class="textbox" v-for="(comment, index) in boardComments" :key="index">
            <div style="width: 950px; padding: 2% 0 0 5%;">
                <strong> {{ comment.id }} </strong> 
                <span class="date">
                    {{ comment.regDate}} 
                    <v-btn color="black" text type="button" @click="writeComment(index, comment)">
                        <strong>답글</strong> 
                    </v-btn>  
                </span><br>
                <span class="comments"> 
                    {{ comment.comments}} 
                </span>
                <span> <br>
                    <v-img v-if="comment.commentLinkInfo != null" v-bind:src="require(`@/assets/boardComment/${comment.commentLinkInfo}`)" contain style="height:300px; width:300px position: fixed;" />
                </span><br>

                <div v-show="writeCoComent" v-if="index == checkIndex" style="padding: 0 0 0 3%;">
                    <form @submit.prevent="onSubmit2">
                        <v-container>
                            <v-row >
                                <v-col>
                                    <h4>댓글 : <strong>{{id}}</strong></h4>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col class="col-12 col-sm-10">
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
        
    </div>
</template>


<script>
    export default {
        name: 'BookingBoaradCocomentForm',
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
                checkIndex:'',
                checkCommentNo:''
            }
        }, 
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit2 () {
                const { checkCommentNo, id, comments, files1 } = this
                this.$emit('submit', { checkCommentNo, id, comments, files1 })
            },
            writeComment (index, comment) {
                this.checkIndex = index
                this.checkCommentNo = comment.commentNo

                if(this.writeCoComent == false)
                this.writeCoComent = true
                else this.writeCoComent = false
                
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
    font-size: 13px;
    color: rgb(100, 96, 96);
}
</style>