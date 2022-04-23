<template>
    <v-container>
        <v-toolbar color="black" dark class="mx-auto" height="55">
            <v-layout row wrap>
                <v-tabs v-model="tabs">
                    <v-tab v-show="neverNoShow">
                        <router-link to="/main">Home</router-link>
                    </v-tab> 
                    <v-tab 
                        v-for="item in items"
                        :key="item.title" 
                        :to ="item.route"
                    >
                        {{ item.title }}
                    </v-tab>
                
                        <v-menu open-on-hover bottom left>
                            <template v-slot:activator="{ on, attrs }">
                                <v-btn
                                    text
                                    class="align-self-center with"
                                    v-bind="attrs"
                                    v-on="on"
                                > 
                                <v-icon right>
                                mdi-menu-down
                                </v-icon>
                                </v-btn>
                            </template>
                            <v-list class="black" dark>
                                <v-list-item
                                    v-for="item in more"
                                    :key="item.title"
                                    :to ="item.route"
                                    @click="addItem(item)"
                                >
                                    {{ item.title }}
                                </v-list-item>
                            </v-list>
                        </v-menu>
                   
                    
                </v-tabs>
            </v-layout>
        </v-toolbar>
    </v-container>
    
</template>

<script>

export default {
    
    name: "MainToolbar",
    data: () => ({
        tabs:null,
        items: [
            {title: 'Community', route: '/community'},
            {title: 'Market', route:'/market'},
            {title:'Review', route:'/review'},
            {title: 'Study', route:'/study'},
        ],
        more: [
            {title: 'Project', route:'/project'}
      ],
        neverNoShow: false
    }),
    methods: {
        addItem (item) {
        const removed = this.items.splice(3, 1)
        this.items.push(
          ...this.more.splice(this.more.indexOf(item), 1),
        )
        this.more.push(...removed)
        },
    
        
    }
}
</script>

<style scoped>
.v-toolbar {
    width: 95%;
}
.v-tab {
    position:relative;
    margin-left: auto;
    margin-right: auto;
    font-weight: bold;
}
.with{
    position: absolute;
    left:89%;
}
</style>