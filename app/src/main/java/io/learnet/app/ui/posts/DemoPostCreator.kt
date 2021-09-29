package io.learnet.app.ui.posts



/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class DemoPostCreator {
    companion object {
        fun createPostList(numPosts: Int): ArrayList<*> {
            val posts = ArrayList<PostItem>()
            for (i in 1..numPosts) {
                posts.add(
                    PostItem(
                    "John",
                "Glenn",
                "https://i.picsum.photos/id/287/200/200.jpg?hmac=kXFCSMZE2rF7NM-EFSH6c_nl5HlKQWvwCdE8JYL-YNQ",
                "Celestial bodies rock",
                "1h ago",
                    "Did you know that the sun revolves around the Milky Way Galaxy!? " +
                            "It does this every 200 millions or so, which means it...",
                    235,
                    81,
                    1544))
            }
            return posts
        }

        fun createPostDetail(): PostDetailItem {
            return PostDetailItem(
                        "John",
                        "Glenn",
                        "https://i.picsum.photos/id/287/200/200.jpg?hmac=kXFCSMZE2rF7NM-EFSH6c_nl5HlKQWvwCdE8JYL-YNQ",
                        "Celestial bodies rock",
                        "1h ago",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                                "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore " +
                                "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim " +
                                "ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia " +
                                "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque " +
                                "porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci " +
                                "velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam " +
                                "aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem " +
                                "ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? " +
                                "Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil " +
                                "molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur",
                        235,
                        81,
                        1544)
            }

        fun createPostReplies(numReplies: Int): ArrayList<PostReplyItem> {
            val replies = ArrayList<PostReplyItem>()
            for (i in 1..numReplies) {
                replies.add(
                    PostReplyItem(
                        "John",
                        "Glenn",
                        "https://i.picsum.photos/id/287/200/200.jpg?hmac=kXFCSMZE2rF7NM-EFSH6c_nl5HlKQWvwCdE8JYL-YNQ",
                        "1h ago",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
                                "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore" +
                                "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ",
                        235))
            }
            return replies
        }
    }
}