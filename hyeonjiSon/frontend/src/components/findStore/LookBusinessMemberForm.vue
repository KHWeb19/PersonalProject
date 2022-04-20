<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table
                        :headers="headerTitle" 
                        :items="businessMembers"
                        :key="businessMembers.memberNo"
                        :items-per-page="10"
                        class="elevation-1" 
                        >
                <template v-slot:[`item.id`]="{ item }">
                  <div>{{ item.city}} </div>
                </template>
            </v-data-table>
        </v-row>
    </v-container>
</template>

<script>
import {mapActions, mapState} from 'vuex';

export default {
    name: "LookBusinessMemberForm.vue",
    props: {
        communityBoards: {
            type:Array
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'시', value: 'city', width:'150px'},
                { text:'동', value: 'dong', width:'150px'},
                { text: '주소', value: 'address', width: "350px" },
                { text: '상호명', value: 'sn', width: "150px" },
            ],
            keyword:'',
            searchList: []
        }
    },
    computed: {
        ...mapState(['businessMembers']),
    },
    mounted () {
        this.fetchBusinessMember()
    },
    methods: {
        ...mapActions(['fetchBusinessMember']),

    }
}
</script>

<style scoped>
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>