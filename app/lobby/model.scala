package lila
package lobby

import socket.SocketMember

import scalaz.effects.IO

case class Member(
    channel: Channel,
    username: Option[String],
    hookOwnerId: Option[String]) extends SocketMember {

  def ownsHook(hook: model.Hook) = Some(hook.ownerId) == hookOwnerId
}

case class WithHooks(op: Iterable[String] => IO[Unit])
case class AddHook(hook: model.Hook)
case class RemoveHook(hook: model.Hook)
case class BiteHook(hook: model.Hook, game: model.DbGame)
case class Entry(entry: model.Entry)
case class Join(
    uid: String,
    username: Option[String],
    version: Int,
    hookOwnerId: Option[String])
case class Talk(txt: String, u: String)
case class Connected(channel: Channel)
